package com.example.domain.di

import com.example.domain.use_case.GetCharactersUseCase
import com.example.domain.use_case.GetEpisodesUseCase
import com.example.domain.use_case.GetLocationsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetCharactersUseCase)
    factoryOf(::GetEpisodesUseCase)
    factoryOf(::GetLocationsUseCase)
}