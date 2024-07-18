package com.badista.movieskmm.data.remote

@kotlinx.serialization.Serializable
internal data class MovieResponse(
    val results: List<MovieRemote>
)
