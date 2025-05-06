package com.vipermech.mindtrack.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vipermech.mindtrack.presentation.ui.navigation.routesnav.NavigationItems
import com.vipermech.mindtrack.presentation.ui.navigation.routesnav.NavigationItemsBottomBar
import com.vipermech.mindtrack.presentation.ui.screens.auth.LoginScreen
import com.vipermech.mindtrack.presentation.ui.screens.emotions.EmotionsScreen
import com.vipermech.mindtrack.presentation.ui.screens.home.HomeScreen
import com.vipermech.mindtrack.presentation.ui.screens.settings.SettingsScreen
import com.vipermech.mindtrack.presentation.ui.screens.statistics.StatisticsScreen
import com.vipermech.mindtrack.presentation.ui.screens.tasks.TasksScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavigationItems.Login.route,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItems.Login.route) {
            LoginScreen(viewModel = hiltViewModel()) {
            // Successful login navigation to Home
            navController.navigate(NavigationItemsBottomBar.Home.route) {
                popUpTo(NavigationItems.Login) { inclusive = true }
            }
        } }
        composable(NavigationItemsBottomBar.Home.route) { HomeScreen(navController) }
        composable(NavigationItemsBottomBar.Tasks.route) { TasksScreen() }
        composable(NavigationItemsBottomBar.Emotion.route) { EmotionsScreen() }
        composable(NavigationItemsBottomBar.Stats.route) { StatisticsScreen() }
        composable(NavigationItemsBottomBar.Settings.route) { SettingsScreen() }
    }
}
