package com.cruz.republicservices.domain.usecase

import com.cruz.republicservices.data.repository.IDriverRepository
import com.cruz.republicservices.domain.mapper.mapToRoute
import com.cruz.republicservices.domain.model.Route
import javax.inject.Inject

class GetRoutesForDriverUseCase @Inject constructor(
    private val driverRepository: IDriverRepository
) {

    /**
     * Gets complete list of routes.
     * Creates a @see[Map] of routes grouped by type.
     * Creates a list of any route with the same @param[id].
     * Adds the first R type route if @param[id] is divisible by 2.
     * Adds the second C type route if @param[id] is divisible by 5.
     * If none of the conditions are met then adds the last I type route.
     */
    suspend operator fun invoke(id: Int): List<Route> {
        val routes = driverRepository.getRoutes()
        val matchedRoutes = routes.filter { it.id == id } as MutableList
        val routeMap = routes.groupBy { it.type }
        val isDivisibleByTwo = (id % 2) == 0
        val isDivisibleByFive = (id % 5) == 0

        if (isDivisibleByTwo) {
            val route = routeMap["R"]?.get(0)
            if (route != null) {
                matchedRoutes.add(route)
            }
        }

        if (isDivisibleByFive) {
            val route = routeMap["C"]?.get(1)
            if (route != null) {
                matchedRoutes.add(route)
            }
        }

        if (matchedRoutes.isEmpty()) {
            val route = routeMap["I"]?.last()
            if (route != null) {
                matchedRoutes.add(route)
            }
        }

        return matchedRoutes.distinct().mapToRoute()
    }
}
