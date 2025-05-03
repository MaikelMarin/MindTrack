package com.vipermech.mindtrack.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.core.view.WindowCompat
import com.vipermech.mindtrack.ui.navigation.MindTrackNavHost
import com.vipermech.mindtrack.ui.theme.MindTrackTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hacer la app edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MindTrackApp()
        }
    }
}

@Composable
fun MindTrackApp() {
    MindTrackTheme {
        Surface {
            MindTrackNavHost()
        }
    }
}