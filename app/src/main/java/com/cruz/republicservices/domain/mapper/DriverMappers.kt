package com.cruz.republicservices.domain.mapper

import com.cruz.republicservices.data.local.entity.DriverEntity
import com.cruz.republicservices.data.local.entity.RouteEntity
import com.cruz.republicservices.domain.model.Driver
import com.cruz.republicservices.domain.model.Route

internal fun List<DriverEntity>.mapToDriver(): List<Driver> {
    return map { it.asDriver }
}

private val DriverEntity.asDriver
    get() = Driver(id, name)

internal fun List<RouteEntity>.mapToRoute(): List<Route> {
    return map { it.asRoute }
}

private val RouteEntity.asRoute
    get() = Route(id, type, name)
