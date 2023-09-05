package com.example.data.remote.model

data class BasePagingResponse<T>(
    val info: InfoDto,
    val results: List<T>
)