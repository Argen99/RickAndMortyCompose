package com.example.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.remote.api_service.RickAndMortyApiService
import com.example.data.remote.paging_src.CharacterPagingSource
import com.example.data.remote.paging_src.EpisodePagingSource
import com.example.data.remote.paging_src.LocationPagingSource
import com.example.domain.model.CharacterModel
import com.example.domain.model.EpisodeModel
import com.example.domain.model.LocationModel
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(
    private val apiService: RickAndMortyApiService
): MainRepository {
    override fun getCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                CharacterPagingSource(apiService = apiService)
            }
        ).flow
    }

    override fun getEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                EpisodePagingSource(apiService = apiService)
            }
        ).flow
    }

    override fun getLocations(): Flow<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                LocationPagingSource(apiService = apiService)
            }
        ).flow
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}