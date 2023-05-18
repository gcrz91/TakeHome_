package com.cruz.republicservices.domain.usecase

import com.cruz.republicservices.data.repository.IDriverRepository
import com.cruz.republicservices.domain.mapper.mapToDriver
import com.cruz.republicservices.domain.model.Driver
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetDriversUseCase @Inject constructor(
    private val driverRepository: IDriverRepository
) {
    operator fun invoke(): Flow<List<Driver>> {
        return driverRepository.getDrivers().map { it.mapToDriver() }
    }
}
