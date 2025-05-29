package com.vipermech.mindtrack.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.vipermech.mindtrack.presentation.ui.componets.BottomNavigationBar
import com.vipermech.mindtrack.presentation.ui.navigation.NavigationGraph
import com.vipermech.mindtrack.presentation.ui.theme.MindTrackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MindTrackApp()
        }
    }
}

@Composable
fun MindTrackApp() {
    val navController = rememberNavController()
    MindTrackTheme {
        Surface {
            NavigationGraph(
                navController = navController,
                modifier = Modifier
            )
        }
    }
}
