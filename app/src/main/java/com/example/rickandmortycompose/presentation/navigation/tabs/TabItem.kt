package com.example.rickandmortycompose.presentation.navigation.tabs

import androidx.compose.runtime.Composable

data class TabItem (
    val title: String,
    val screen: @Composable () -> Unit
)