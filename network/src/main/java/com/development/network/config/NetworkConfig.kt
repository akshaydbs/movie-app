package com.development.network.config

data class NetworkConfig(
    val baseUrl: String,
    val timeouts: TimeoutConfig = TimeoutConfig(),
    val logging: LoggingConfig = LoggingConfig(),
    val pinning: PinningConfig? = null,
    val defaultHeaders: Map<String, String> = emptyMap(),
)