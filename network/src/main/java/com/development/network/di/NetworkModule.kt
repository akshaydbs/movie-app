package com.development.network.di

import com.development.network.config.NetworkConfig
import com.development.network.config.LoggingConfig
import com.development.network.factory.ConverterFactoryProvider
import com.development.network.factory.OkHttpFactory
import com.development.network.factory.RetrofitFactoryProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter

public val networkModule = module {

    single {
        NetworkConfig(
            baseUrl = "https://api.example.com/",
            logging = LoggingConfig(
                enabled = true,
                level = HttpLoggingInterceptor.Level.BODY
            ),
            defaultHeaders = mapOf(
                "Accept" to "application/json"
            )
        )
    }

    single<OkHttpClient> {
        OkHttpFactory.create(
            config = get()
        )
    }

    single {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        RetrofitFactoryProvider(
            okHttpClient = get(),
            converterFactory = get(),
        )
    }
}