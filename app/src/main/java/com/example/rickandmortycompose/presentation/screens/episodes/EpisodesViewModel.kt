package com.example.rickandmortycompose.presentation.screens.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.model.CharacterModel
import com.example.domain.model.EpisodeModel
import com.example.domain.use_case.GetEpisodesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class EpisodesViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase
): ViewModel() {

    private val _episodesState: MutableStateFlow<PagingData<EpisodeModel>> = MutableStateFlow(
        PagingData.empty())
    val episodesState: MutableStateFlow<PagingData<EpisodeModel>> get() = _episodesState

    init {
        getAllEpisodes()
    }

    private fun getAllEpisodes(){
        viewModelScope.launch {
            getEpisodesUseCase()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                    _episodesState.value = it
                }
        }
    }
}