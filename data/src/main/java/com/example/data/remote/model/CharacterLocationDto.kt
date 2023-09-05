package com.example.data.remote.model

import com.example.data.utils.DataMapper
import com.example.domain.model.CharacterLocation

data class CharacterLocationDto(
    val name: String,
    val url: String
) : DataMapper<CharacterLocation> {

    override fun toDomain() = CharacterLocation(
        name = name,
        url = url
    )
}