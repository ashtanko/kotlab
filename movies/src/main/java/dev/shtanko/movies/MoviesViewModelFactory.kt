package dev.shtanko.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.shtanko.movies.repository.MoviesRepository

class MoviesViewModelFactory(
    private val moviesRepository: MoviesRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(moviesRepository) as T
    }
}
