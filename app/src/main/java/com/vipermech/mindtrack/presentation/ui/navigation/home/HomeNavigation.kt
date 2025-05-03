package com.vipermech.mindtrack.presentation.ui.navigation.home
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.vipermech.mindtrack.presentation.ui.screens.home.HomeScreen

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable(route = HOME_ROUTE) {
        HomeScreen()
    }
}