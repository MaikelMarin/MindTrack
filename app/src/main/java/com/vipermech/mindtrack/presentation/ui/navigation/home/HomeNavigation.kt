package com.vipermech.mindtrack.ui.navigation.home
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.vipermech .mindtrack.ui.screens.home.HomeScreen

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable(route = HOME_ROUTE) {
        HomeScreen()
    }
}