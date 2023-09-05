package com.example.rickandmortycompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmortycompose.presentation.screens.characters.CharacterListScreen
import com.example.rickandmortycompose.presentation.screens.episodes.EpisodesListScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Characters.CHARACTERlIST,
        modifier = modifier
    ) {
        composable(route = Characters.CHARACTERlIST) {
            CharacterListScreen()
        }
        composable(route = Episodes.EPISODELIST) {
            EpisodesListScreen()
        }
        composable(route = Locations.LOCATIONlIST) {

        }
    }
}