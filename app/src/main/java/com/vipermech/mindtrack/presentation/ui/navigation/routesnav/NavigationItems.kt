package com.vipermech.mindtrack.presentation.ui.navigation.routesnav

import android.R.attr.type
import android.os.Parcelable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


sealed class NavigationItems(val route: String, val icon: ImageVector, val label: String) {
    object Home : NavigationItems("home", Icons.Default.Home, "Inicio")
    object Tasks : NavigationItems("tasks", Icons.Default.CheckCircle, "Tareas")
    object Emotion : NavigationItems("emotion", Icons.Default.Face, "Emoción")
    object Stats : NavigationItems("stats", Icons.Default.Info, "Estadísticas")
    object Settings : NavigationItems("settings", Icons.Default.Settings, "Ajustes")
}

@Serializable
sealed class NavigationItemsStart(val route: String)  {
    @Serializable
    object Login : NavigationItemsStart("Login")
}