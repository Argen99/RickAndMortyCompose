package com.example.rickandmortycompose.presentation.screens.location

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationListScreen() {
    val viewModel = getViewModel<LocationViewModel>()
    val pagingItems = viewModel.locationState.collectAsLazyPagingItems()

    LazyColumn {
        items(pagingItems.itemCount) { index ->
            pagingItems[index]?.let { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 8.dp,
                            vertical = 4.dp
                        ),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(8.dp),
                    onClick = {}
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 8.dp,
                                vertical = 12.dp
                            ),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = item.name,
                            style = TextStyle(
                                fontFamily = FontFamily.SansSerif
                            )
                        )
                        Text(
                            text = item.dimension,
                            style = TextStyle(
                                fontFamily = FontFamily.SansSerif
                            )
                        )
                        Text(
                            text = item.type,
                            style = TextStyle(
                                fontFamily = FontFamily.SansSerif
                            )
                        )
                    }
                }
            }
        }
    }
}