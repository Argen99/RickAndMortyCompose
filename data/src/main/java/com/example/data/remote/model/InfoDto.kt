package com.example.data.remote.model

import com.example.data.utils.DataMapper
import com.example.domain.model.Info

data class InfoDto(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
) : DataMapper<Info> {

    override fun toDomain() = Info(
        count = count,
        pages = pages,
        next = next,
        prev = prev,
    )
}