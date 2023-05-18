package com.cruz.republicservices.data.remote.client

import com.cruz.republicservices.data.remote.model.DriversResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface DriverService {
    @GET("data")
    suspend fun getDriversAndRoutes(): Response<DriversResponseDto>
}
