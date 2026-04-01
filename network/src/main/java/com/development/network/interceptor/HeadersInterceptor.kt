package com.development.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor(
    private val headersProvider: () -> Map<String, String>,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val newRequestBuilder = originalRequest.newBuilder()

        headersProvider().forEach { (key, value) ->
            newRequestBuilder.header(key, value)
        }

        return chain.proceed(newRequestBuilder.build())
    }
}