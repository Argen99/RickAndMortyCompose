package com.example.rickandmortycompose.presentation.navigation.tabs

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.example.domain.model.CharacterModel
import com.example.rickandmortycompose.presentation.screens.characters.components.CharacterItem

@Composable
fun TabScreen(
    pagingItems: LazyPagingItems<CharacterModel>
) {
    LazyColumn {
        items(pagingItems.itemCount) { index ->
            pagingItems[index]?.let { item ->
                CharacterItem(item = item)
            }
        }
    }
}