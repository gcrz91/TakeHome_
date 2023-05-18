package com.cruz.republicservices.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DriversResponseDto(
    val drivers: List<DriverDto>,
    val routes: List<RouteDto>
)

@JsonClass(generateAdapter = true)
data class DriverDto(
    val id: String,
    val name: String
)

@JsonClass(generateAdapter = true)
data class RouteDto(
    val id: Int,
    val type: String,
    val name: String
)
