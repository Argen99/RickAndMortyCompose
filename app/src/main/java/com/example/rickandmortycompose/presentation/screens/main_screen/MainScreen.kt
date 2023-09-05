package com.example.rickandmortycompose.presentation.screens.main_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortycompose.presentation.navigation.bottom.BottomNavigationBar
import com.example.rickandmortycompose.presentation.navigation.NavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navHostController = navController)
        }
    ) { padding ->
        NavGraph(navHostController = navController, Modifier.padding(padding))
    }
}