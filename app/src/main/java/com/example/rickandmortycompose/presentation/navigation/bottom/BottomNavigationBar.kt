package com.example.rickandmortycompose.presentation.navigation.bottom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rickandmortycompose.presentation.navigation.Characters
import com.example.rickandmortycompose.presentation.navigation.Episodes
import com.example.rickandmortycompose.presentation.navigation.Locations

@Composable
fun BottomNavigationBar(
    navHostController: NavHostController
) {
    val bottomScreens = listOf(
        NavigationItem( Characters.CHARACTERlIST, "Characters",
            Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle),
        NavigationItem( Episodes.EPISODELIST, "Episodes",
            Icons.Filled.List, Icons.Outlined.List),
        NavigationItem( Locations.LOCATIONlIST, "Locations",
            Icons.Filled.LocationOn, Icons.Outlined.LocationOn),
    )

    NavigationBar {
        bottomScreens.forEachIndexed { index, item ->
            val isSelected = navHostController
                .currentBackStackEntryAsState().value?.destination?.route == item.route
            val bottomIcon = if (isSelected) item.selectedIcon else item.unselectedIcon
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navHostController.navigate(item.route)
                },
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = false,
                icon = {
                    Icon(
                        imageVector = bottomIcon,
                        contentDescription = item.title
                    )
                }
            )
        }
    }
}