package com.vipermech.mindtrack.presentation.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.vipermech.mindtrack.presentation.ui.componets.BottomNavigationBar

@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ){
        Box(Modifier.fillMaxSize().padding(it), contentAlignment = Alignment.Center) {
            Text(text = "home")
        }
    }




}