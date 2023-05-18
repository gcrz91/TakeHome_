package com.cruz.republicservices.data.mapper

import com.cruz.republicservices.data.local.entity.DriverEntity
import com.cruz.republicservices.data.local.entity.RouteEntity
import com.cruz.republicservices.data.remote.model.DriverDto
import com.cruz.republicservices.data.remote.model.RouteDto

internal fun List<DriverDto>.mapToDriverEntityList(): List<DriverEntity> {
    return map { it.asDriverEntity }
}

private val DriverDto.asDriverEntity
    get() = DriverEntity(id.toInt(), name)

internal fun List<RouteDto>.mapToRouteEntityList(): List<RouteEntity> {
    return map { it.asRouteEntity }
}

private val RouteDto.asRouteEntity
    get() = RouteEntity(id, type, name)
