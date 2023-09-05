package com.example.data.remote.model

import com.example.data.utils.DataMapper
import com.example.domain.model.Origin

data class OriginDto(
    val name: String,
    val url: String
) : DataMapper<Origin> {
    override fun toDomain() = Origin(
        name = name,
        url = url
    )
}