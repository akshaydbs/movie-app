package com.development.movie.data.di

import com.development.movie.data.MovieApi
import com.development.movie.data.MovieRepositoryImpl
import com.development.movie.domain.MoviesRepository
import com.development.network.factory.RetrofitFactoryProvider
import org.koin.dsl.module
import retrofit2.Retrofit

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val TMDb_API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYmMzNWFkMTkzZWFiNmM1YjA1ZTcwN2YyZTkwNmJiNiIsInN1YiI6IjVhZmZiMTExMGUwYTI2MzAxYjAwMjlkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.KK9cgic90cW5Fvay1S5KvMYdf7ExoOCPS9GsHbcugnQ"

val movieModule = module{
    single<MovieApi> {provideMovieApi(get())}
    single<MoviesRepository> {provideMovieRepository(get())}
}

fun provideMovieApi(retrofit: RetrofitFactoryProvider): MovieApi {
    return retrofit.create(BASE_URL).create(MovieApi::class.java)
}

fun provideMovieRepository(movieApi: MovieApi): MoviesRepository {
    return MovieRepositoryImpl(movieApi)
}
