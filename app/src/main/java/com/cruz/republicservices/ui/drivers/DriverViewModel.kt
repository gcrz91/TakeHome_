package com.cruz.republicservices.ui.drivers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cruz.republicservices.domain.model.Driver
import com.cruz.republicservices.domain.usecase.FetchDriversUseCase
import com.cruz.republicservices.domain.usecase.GetDriversUseCase
import com.cruz.republicservices.helper.AsyncResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
internal class DriverViewModel @Inject constructor(
    private val fetchDriversUseCase: FetchDriversUseCase,
    private val getDriversUseCase: GetDriversUseCase
) : ViewModel() {

    private val fetchResult = fetchDriversUseCase().flowOn(Dispatchers.IO)
    private val _driverList = MutableStateFlow<List<Driver>>(emptyList())

    val viewState: StateFlow<ViewState> = combine(
        fetchResult,
        _driverList
    ) { result, drivers ->
        ViewState(
            isLoading = result is AsyncResult.Loading,
            error = (result as? AsyncResult.Failure)?.error,
            drivers = drivers
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = ViewState()
    )

    init {
        fetchData()
        getDrivers()
    }

    private fun fetchData() {
        viewModelScope.launch {
            fetchDriversUseCase()
        }
    }

    private fun getDrivers() {
        viewModelScope.launch {
            getDriversUseCase().collect {
                _driverList.value = it
            }
        }
    }

    /**
     * Based on the latest list of drivers. The drivers name is split
     * into an array based on the components and sorted in alphabetical
     * order based on last name.
     */
    fun sortByLastName() {
        viewModelScope.launch {
            val drivers = _driverList.value
            val sortedDrivers = drivers.sortedBy { driver ->
                val components = driver.name.split(" ")
                components.last()
            }
            _driverList.value = sortedDrivers
        }
    }

    data class ViewState(
        val isLoading: Boolean = true,
        val error: String? = null,
        val drivers: List<Driver> = emptyList()
    )
}
