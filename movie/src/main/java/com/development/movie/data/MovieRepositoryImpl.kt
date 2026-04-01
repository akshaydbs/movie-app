package com.development.movie.data

import com.development.movie.data.mapper.toDomain
import com.development.movie.domain.Movie
import com.development.movie.domain.MoviesRepository

class MovieRepositoryImpl(
    private val moviesApi: MovieApi
) : MoviesRepository {

    override suspend fun getPopularMovies(): List<Movie> {
        return moviesApi.getPopularMovies()
            .results
            .map { it.toDomain() }
    }
}