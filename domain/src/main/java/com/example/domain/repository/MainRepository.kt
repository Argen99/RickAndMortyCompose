package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.CharacterModel
import com.example.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow


interface MainRepository {

    fun getCharacters() : Flow<PagingData<CharacterModel>>

    fun getEpisodes() : Flow<PagingData<EpisodeModel>>
}