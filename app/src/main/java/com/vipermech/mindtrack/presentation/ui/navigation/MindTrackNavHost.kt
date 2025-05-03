package com.vipermech.mindtrack.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vipermech.mindtrack.presentation.ui.navigation.home.HOME_ROUTE
import com.vipermech.mindtrack.presentation.ui.navigation.home.homeScreen

@Composable
fun MindTrackNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        homeScreen(navController)
        // Aquí puedes ir agregando más pantallas: emotionsScreen(), statisticsScreen(), etc.
    }
}