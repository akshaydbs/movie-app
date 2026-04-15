package com.development.movie.ui

import com.development.movie.domain.Movie

data class MoviesUiState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val errorMessage: String? = null
)