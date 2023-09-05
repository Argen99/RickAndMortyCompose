package com.example.data.remote.paging_src

import com.example.data.remote.api_service.RickAndMortyApiService
import com.example.data.remote.model.LocationDto
import com.example.data.utils.BasePagingSource
import com.example.domain.model.LocationModel

class LocationPagingSource(
    private val apiService: RickAndMortyApiService
): BasePagingSource<LocationDto, LocationModel>({
    apiService.getAllLocations(it)
})