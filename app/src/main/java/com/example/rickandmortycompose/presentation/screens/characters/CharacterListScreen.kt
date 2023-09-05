package com.example.rickandmortycompose.presentation.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.domain.model.CharacterModel
import com.example.rickandmortycompose.presentation.navigation.tabs.TabItem
import com.example.rickandmortycompose.presentation.navigation.tabs.TabScreen
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterListScreen() {

    val viewModel = getViewModel<CharacterViewModel>()
    val pagingItems: LazyPagingItems<CharacterModel> =
        viewModel.characterState.collectAsLazyPagingItems()

    val tabs = listOf(
        TabItem(
            title = "Character List",
            screen = { TabScreen(pagingItems = pagingItems) }
        ),
        TabItem(
            title = "Favorite List",
            screen = { TabScreen(pagingItems = emptyFlow<PagingData<CharacterModel>>().collectAsLazyPagingItems()) }
        )
    )
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        tabs.size
    }
    Column (
        modifier = Modifier
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
        ) {
            tabs.forEachIndexed { index, item ->
                Tab(
                    selected = index == pagerState.currentPage,
                    unselectedContentColor = Color.Gray,
                    text = { Text(text = item.title) },
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                )
            }
        }
        HorizontalPager(state = pagerState) {
            tabs[pagerState.currentPage].screen()
        }
    }
}