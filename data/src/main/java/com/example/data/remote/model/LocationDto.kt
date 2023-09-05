package com.example.data.remote.model

import com.example.data.utils.DataMapper
import com.example.domain.model.LocationModel

data class LocationDto(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
): DataMapper<LocationModel> {

    override fun toDomain() = LocationModel(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        residents = residents,
        url = url,
        created = created
    )
}