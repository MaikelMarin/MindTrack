package com.vipermech.mindtrack.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vipermech.mindtrack.presentation.ui.navigation.routesnav.NavigationItems
import com.vipermech.mindtrack.presentation.ui.navigation.routesnav.NavigationItemsContainer
import com.vipermech.mindtrack.presentation.ui.navigation.routesnav.NavigationItemsStart
import com.vipermech.mindtrack.presentation.ui.screens.auth.LoginScreen
import com.vipermech.mindtrack.presentation.ui.screens.containe.ContainerUI
import com.vipermech.mindtrack.presentation.ui.screens.emotions.EmotionsScreen
import com.vipermech.mindtrack.presentation.ui.screens.home.HomeScreen
import com.vipermech.mindtrack.presentation.ui.screens.settings.SettingsScreen
import com.vipermech.mindtrack.presentation.ui.screens.statistics.StatisticsScreen
import com.vipermech.mindtrack.presentation.ui.screens.tasks.TasksScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavigationItemsStart.Login.route,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItemsStart.Login.route) {
            LoginScreen(viewModel = hiltViewModel()){
                navController.navigate(NavigationItems.Container.route) {
                navController.popBackStack(NavigationItemsStart.Login.route, inclusive = true)
            }
        } }
        composable(NavigationItems.Container.route){ContainerUI(navController)}
        composable(NavigationItemsContainer.Home.route){ HomeScreen(navController) }
        composable(NavigationItemsContainer.Tasks.route) { TasksScreen() }
        composable(NavigationItemsContainer.Emotion.route) { EmotionsScreen() }
        composable(NavigationItemsContainer.Stats.route) { StatisticsScreen() }
        composable(NavigationItemsContainer.Settings.route) { SettingsScreen() }
    }
}
