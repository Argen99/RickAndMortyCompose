package com.example.data.remote.paging_src

import com.example.data.remote.api_service.RickAndMortyApiService
import com.example.data.remote.model.EpisodeDto
import com.example.data.utils.BasePagingSource
import com.example.domain.model.EpisodeModel

class EpisodePagingSource(
    private val apiService: RickAndMortyApiService
): BasePagingSource<EpisodeDto, EpisodeModel>({
    apiService.getAllEpisodes(it)
})