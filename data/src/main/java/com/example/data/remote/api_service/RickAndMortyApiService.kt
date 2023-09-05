package com.example.data.remote.api_service

import com.example.data.remote.model.CharacterDto
import com.example.data.remote.model.BasePagingResponse
import com.example.data.remote.model.EpisodeDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiService {

    @GET("api/character")
    suspend fun getCharacters(
        @Query("page") page: Int?,
//        @Query("name") name: String?,
//        @Query("status") status: String?,
//        @Query("species") species: String?,
//        @Query("gender") gender: String?
    ): BasePagingResponse<CharacterDto>

    @GET("api/episode")
    suspend fun getAllEpisodes(
        @Query("page") page: Int?,
//        @Query("name") name: String?
    ) : BasePagingResponse<EpisodeDto>

    @GET("api/location")
    suspend fun getAllLocations(
        @Query("page") page: Int?,
//        @Query("name") name: String?
    )
}