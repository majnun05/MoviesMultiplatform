package com.badista.movieskmm.di

import com.badista.movieskmm.data.remote.MovieService
import com.badista.movieskmm.data.remote.RemoteDataSource
import com.badista.movieskmm.data.repository.MovieRepositoryImpl
import com.badista.movieskmm.domain.repository.MovieRepository
import com.badista.movieskmm.domain.usecase.GetMovieUseCase
import com.badista.movieskmm.domain.usecase.GetMoviesUseCase
import com.badista.movieskmm.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
}

private val sharedModule = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModule