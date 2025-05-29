package com.vipermech.mindtrack.presentation.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.vipermech.mindtrack.presentation.ui.componets.BottomNavigationBar

@Composable
fun HomeScreen(navController: NavHostController, list: List<String>) {

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = list.listIterator().next())
    }




}