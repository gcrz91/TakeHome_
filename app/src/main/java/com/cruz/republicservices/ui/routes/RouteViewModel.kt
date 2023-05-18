package com.cruz.republicservices.ui.routes

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cruz.republicservices.domain.model.Route
import com.cruz.republicservices.domain.usecase.GetRoutesForDriverUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
internal class RouteViewModel @Inject constructor(
    private val getRoutesForDriverUseCase: GetRoutesForDriverUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _viewState = MutableStateFlow(ViewState(routes = emptyList()))
    val viewState = _viewState.asStateFlow()

    init {
        savedStateHandle.get<Int>("id")?.let {
            getRoutesForDriver(it)
        }
    }

    private fun getRoutesForDriver(id: Int) {
        viewModelScope.launch {
            _viewState.value = ViewState(routes = getRoutesForDriverUseCase(id))
        }
    }

    data class ViewState(val routes: List<Route>)
}
