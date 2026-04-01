package com.development.network.config

import okhttp3.logging.HttpLoggingInterceptor

data class LoggingConfig(
    val enabled: Boolean = false,
    val level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.NONE,
)