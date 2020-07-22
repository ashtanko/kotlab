package dev.shtanko.movies.di

import dev.shtanko.movies.MoviesViewModelFactory
import dev.shtanko.movies.network.api.MovieService
import dev.shtanko.movies.repository.MoviesRepository

fun provideMoviesViewModelFactory(): MoviesViewModelFactory {
    val repository = MoviesRepository(MovieService.create())
    return MoviesViewModelFactory(repository)
}
