package dev.shtanko.movies

import androidx.lifecycle.ViewModel
import dev.shtanko.movies.repository.MoviesRepository

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel()
