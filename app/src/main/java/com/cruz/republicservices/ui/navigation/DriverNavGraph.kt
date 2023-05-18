package com.cruz.republicservices.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cruz.republicservices.ui.drivers.DriversScreen
import com.cruz.republicservices.ui.routes.RoutesScreen

private const val DRIVER_SCREEN = "driver_screen"
private const val ROUTE_SCREEN = "route_screen"

@Composable
fun DriverNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = DRIVER_SCREEN) {
        composable(DRIVER_SCREEN) {
            DriversScreen(
                onDriverClick = { id ->
                    navController.navigate("$ROUTE_SCREEN/$id")
                }
            )
        }
        composable(
            route = "$ROUTE_SCREEN/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            RoutesScreen()
        }
    }
}
