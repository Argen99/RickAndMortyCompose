package com.example.data.remote.paging_src

import com.example.data.remote.api_service.RickAndMortyApiService
import com.example.data.remote.model.CharacterDto
import com.example.data.utils.BasePagingSource
import com.example.domain.model.CharacterModel

class CharacterPagingSource(
    private val apiService: RickAndMortyApiService
) : BasePagingSource<CharacterDto, CharacterModel>({
    apiService.getCharacters(it)
})