package com.development.movie.data

import com.development.movie.data.model.MoviesResponseDto
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesResponseDto

    @GET("search/movie")
    fun fetchMovieByQueryAsync(@Query("query") query: String): Deferred<Response<MoviesResponseDto>>
}