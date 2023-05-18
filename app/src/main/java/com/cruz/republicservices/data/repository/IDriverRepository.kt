package com.cruz.republicservices.data.repository

import com.cruz.republicservices.data.local.dao.DriverDao
import com.cruz.republicservices.data.local.dao.RouteDao
import com.cruz.republicservices.data.local.entity.DriverEntity
import com.cruz.republicservices.data.local.entity.RouteEntity
import com.cruz.republicservices.data.mapper.mapToDriverEntityList
import com.cruz.republicservices.data.mapper.mapToRouteEntityList
import com.cruz.republicservices.data.remote.client.DriverService
import com.cruz.republicservices.data.remote.model.DriversResponseDto
import com.cruz.republicservices.helper.AsyncResult
import com.cruz.republicservices.helper.failure
import com.cruz.republicservices.helper.success
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class DriverRepository @Inject constructor(
    private val driverService: DriverService,
    private val driverDao: DriverDao,
    private val routeDao: RouteDao
) : IDriverRepository {

    /**
     * Calls api to get latest driver data.
     * Given the response is successful the drivers and routes are populated to database.
     */
    override fun fetchDriversAndRoutes() = flow {
        emit(AsyncResult.Loading)

        val result = runCatching {
            val response = driverService.getDriversAndRoutes()
            if (response.isSuccessful && response.body() != null) {
                val responseBody = response.body() as DriversResponseDto
                val drivers = responseBody.drivers.mapToDriverEntityList()
                val routes = responseBody.routes.mapToRouteEntityList()

                driverDao.insertDrivers(drivers)
                routeDao.insertRoutes(routes)
                success(Unit)
            } else {
                failure("")
            }
        }.getOrElse {
            failure(it.localizedMessage ?: "Unexpected Error.")
        }
        emit(result)
    }

    override fun getDrivers(): Flow<List<DriverEntity>> {
        return driverDao.getDrivers()
    }

    override suspend fun getRoutes(): List<RouteEntity> {
        return routeDao.getRoutes()
    }
}

interface IDriverRepository {
    fun fetchDriversAndRoutes(): Flow<AsyncResult<Unit>>
    fun getDrivers(): Flow<List<DriverEntity>>
    suspend fun getRoutes(): List<RouteEntity>
}
