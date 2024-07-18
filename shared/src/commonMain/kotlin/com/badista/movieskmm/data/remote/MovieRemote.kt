package com.badista.movieskmm.data.remote


@kotlinx.serialization.Serializable
internal data class MovieRemote(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String
)
