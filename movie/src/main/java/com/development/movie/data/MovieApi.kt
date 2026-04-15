package com.development.movie.data

import com.development.movie.data.model.MoviesResponseDto
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesResponseDto

}