package com.development.network.factory

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

class RetrofitFactoryProvider(
    private val okHttpClient: OkHttpClient,
    private val converterFactory: Converter.Factory,
) {

    fun create(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    inline fun <reified T> createService(baseUrl: String): T {
        return create(baseUrl).create(T::class.java)
    }
}
