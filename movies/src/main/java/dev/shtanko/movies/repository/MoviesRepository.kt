package dev.shtanko.movies.repository

import dev.shtanko.movies.network.api.MovieService

class MoviesRepository constructor(
    private val service: MovieService
)
