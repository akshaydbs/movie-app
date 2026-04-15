package com.development.movie.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun MoviesRoute() {
    val viewModel: MovieViewModel = koinViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    MovieScreen(uiState.value.movies)
}