package com.example.rickandmortycompose.presentation.screens.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.model.LocationModel
import com.example.domain.use_case.GetLocationsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class LocationViewModel(
    private val getLocationsUseCase: GetLocationsUseCase
): ViewModel() {

    private val _locationState: MutableStateFlow<PagingData<LocationModel>> = MutableStateFlow(
        PagingData.empty())
    val locationState: MutableStateFlow<PagingData<LocationModel>> get() = _locationState

    init {
        getAllLocations()
    }

    private fun getAllLocations(){
        viewModelScope.launch {
            getLocationsUseCase()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                    _locationState.value = it
                }
        }
    }
}