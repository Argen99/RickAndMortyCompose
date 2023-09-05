package com.example.data.remote.model

import com.example.data.utils.DataMapper
import com.example.domain.model.EpisodeModel
import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    val id: Int,
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
) : DataMapper<EpisodeModel> {

    override fun toDomain() = EpisodeModel(
        id = id,
        name = name,
        airDate = airDate,
        episode = episode,
        characters = characters,
        url = url,
        created = created,
    )
}