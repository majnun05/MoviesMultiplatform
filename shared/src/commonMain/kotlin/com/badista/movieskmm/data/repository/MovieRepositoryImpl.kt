package com.badista.movieskmm.data.repository

import com.badista.movieskmm.data.remote.RemoteDataSource
import com.badista.movieskmm.data.util.toMovie
import com.badista.movieskmm.domain.model.Movie
import com.badista.movieskmm.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDateSource: RemoteDataSource
): MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDateSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDateSource.getMovie(movieId = movieId).toMovie()
    }
}