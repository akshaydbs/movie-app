package com.development.network.factory

import com.squareup.moshi.Moshi
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

class ConverterFactoryProvider(private val moshi: Moshi) {

    fun provide(): Converter.Factory {
        return MoshiConverterFactory.create()
    }
}