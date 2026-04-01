package com.development.movie.domain

interface MoviesRepository {
    suspend fun getPopularMovies(): List<Movie>
}