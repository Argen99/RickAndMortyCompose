package com.example.domain.use_case

import com.example.domain.repository.MainRepository

class GetCharactersUseCase(
    private val repository: MainRepository
) {
    operator fun invoke() = repository.getCharacters()
}