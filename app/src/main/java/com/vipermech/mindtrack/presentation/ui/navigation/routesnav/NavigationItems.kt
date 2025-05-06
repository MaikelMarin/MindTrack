package com.vipermech.mindtrack.presentation.ui.navigation.routesnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItems(val route: String) {
    object Login : NavigationItems("login")
    object Register : NavigationItems("register")
}

sealed class NavigationItemsBottomBar(val route: String, val icon: ImageVector, val label: String) {
    object Home : NavigationItemsBottomBar("home", Icons.Default.Home, "Inicio")
    object Tasks : NavigationItemsBottomBar("tasks", Icons.Default.CheckCircle, "Tareas")
    object Emotion : NavigationItemsBottomBar("emotion", Icons.Default.Face, "Emoción")
    object Stats : NavigationItemsBottomBar("stats", Icons.Default.Info, "Estadísticas")
    object Settings : NavigationItemsBottomBar("settings", Icons.Default.Settings, "Ajustes")
}