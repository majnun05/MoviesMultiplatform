package com.badista.movieskmm.data.util

import com.badista.movieskmm.data.remote.MovieRemote
import com.badista.movieskmm.domain.model.Movie

internal fun MovieRemote.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        poster_path = getImageURL(poster_path),
        release_date = release_date,
    )
}

private fun getImageURL(posterImage: String) = "https://image.tmdb.org/t/p/w500/$posterImage"