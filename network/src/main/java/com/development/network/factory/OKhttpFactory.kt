package com.development.network.factory

import com.development.network.config.NetworkConfig
import com.development.network.config.PinningConfig
import com.development.network.interceptor.HeadersInterceptor
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpFactory {

    fun create(
        config: NetworkConfig,
        extraInterceptors: List<Interceptor> = emptyList(),
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(config.timeouts.connectTimeoutSeconds, TimeUnit.SECONDS)
            .readTimeout(config.timeouts.readTimeoutSeconds, TimeUnit.SECONDS)
            .writeTimeout(config.timeouts.writeTimeoutSeconds, TimeUnit.SECONDS)
            .apply {
                addInterceptor(
                    HeadersInterceptor {
                        config.defaultHeaders
                    }
                )

                extraInterceptors.forEach(::addInterceptor)

                if (config.logging.enabled) {
                    addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = config.logging.level
                        }
                    )
                }

                config.pinning?.let { pinningConfig ->
                    certificatePinner(createCertificatePinner(pinningConfig))
                }
            }
            .build()
    }

    private fun createCertificatePinner(
        config: PinningConfig,
    ): CertificatePinner {
        return CertificatePinner.Builder().apply {
            config.pins.forEach { pin ->
                add(config.hostname, pin)
            }
        }.build()
    }
}