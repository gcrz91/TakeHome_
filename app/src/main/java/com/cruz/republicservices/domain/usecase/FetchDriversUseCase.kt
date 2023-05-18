package com.cruz.republicservices.domain.usecase

import com.cruz.republicservices.data.repository.IDriverRepository
import com.cruz.republicservices.helper.AsyncResult
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class FetchDriversUseCase @Inject constructor(
    private val driverRepository: IDriverRepository
) {
    operator fun invoke(): Flow<AsyncResult<Unit>> {
        return driverRepository.fetchDriversAndRoutes()
    }
}
