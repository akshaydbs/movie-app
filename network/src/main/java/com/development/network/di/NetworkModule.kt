package com.development.network.di

import com.development.network.config.NetworkConfig
import com.development.network.config.LoggingConfig
import com.development.network.factory.RetrofitFactoryProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

public val networkModule = module {

    single {
        NetworkConfig(
            baseUrl = "https://api.themoviedb.org/3/",
            logging = LoggingConfig(
                enabled = true,
                level = HttpLoggingInterceptor.Level.BODY
            ),
            defaultHeaders = mapOf(
                "Accept" to "application/json",
                "Authorization" to "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYmMzNWFkMTkzZWFiNmM1YjA1ZTcwN2YyZTkwNmJiNiIsIm5iZiI6MTUyNjcwNjQ0OS40NDUsInN1YiI6IjVhZmZiMTExMGUwYTI2MzAxYjAwMjlkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.7AsSBDTCQ_vRQFEsB9TzJh-QOhShhzrkA4U0sOQBd4A"
            )
        )
    }

    single<Interceptor> { provideInterceptor() }

    single<OkHttpClient> {
       provideWeatherApiClient(get())
    }


    single {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<Converter.Factory> {
        MoshiConverterFactory.create()
    }

    single {
        RetrofitFactoryProvider(
            okHttpClient = get(),
            converterFactory = get(),
        )
    }
}

fun provideInterceptor(): Interceptor {
    return Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .addHeader("accept", "application/json")
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYmMzNWFkMTkzZWFiNmM1YjA1ZTcwN2YyZTkwNmJiNiIsIm5iZiI6MTUyNjcwNjQ0OS40NDUsInN1YiI6IjVhZmZiMTExMGUwYTI2MzAxYjAwMjlkYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.7AsSBDTCQ_vRQFEsB9TzJh-QOhShhzrkA4U0sOQBd4A")
            .build()

        chain.proceed(newRequest)
    }
}

fun provideWeatherApiClient(authInterceptor: Interceptor): OkHttpClient {

    val logging = HttpLoggingInterceptor()
// set your desired log level
// set your desired log level
    logging.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(logging)
        .build()
}