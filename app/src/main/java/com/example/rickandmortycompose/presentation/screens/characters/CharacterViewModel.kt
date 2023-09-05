package com.example.rickandmortycompose.presentation.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.model.CharacterModel
import com.example.domain.use_case.GetCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _characterState: MutableStateFlow<PagingData<CharacterModel>> = MutableStateFlow(PagingData.empty())
    val characterState: MutableStateFlow<PagingData<CharacterModel>> get() = _characterState

    init {
        getAllCharacters()
    }

    private fun getAllCharacters(){
        viewModelScope.launch {
            getCharactersUseCase()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                    _characterState.value = it
                }
        }
    }
}