package com.example.rickandmortycompose.di

import com.example.rickandmortycompose.presentation.screens.characters.CharacterViewModel
import com.example.rickandmortycompose.presentation.screens.episodes.EpisodesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::CharacterViewModel)
    viewModelOf(::EpisodesViewModel)
}