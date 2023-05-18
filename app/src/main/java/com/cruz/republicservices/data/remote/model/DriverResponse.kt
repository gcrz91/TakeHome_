package com.cruz.republicservices.data.remote.model

data class DriversResponse(
    val drivers: List<Driver>,
    val routes: List<Route>
)

data class Driver(
    val id: String,
    val name: String
)

data class Route(
    val id: Int,
    val type: String,
    val name: String
)
