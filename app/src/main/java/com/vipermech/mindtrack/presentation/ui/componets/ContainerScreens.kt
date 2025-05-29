package com.vipermech.mindtrack.presentation.ui.componets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.vipermech.mindtrack.presentation.ui.navigation.NavigationGraph

@Composable
fun ContainerScreens(navController: NavHostController){
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ){
        Box(modifier = Modifier.padding(it)){

        }

    }
}