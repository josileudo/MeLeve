package com.example.meleve.core.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object KtorHttpClient {
    object KtorHttpClient {
        private const val NETWORK_TIMEOUT = 5_000L

        val httpClientAndroid by lazy {
            HttpClient(Android) {
                install(ContentNegotiation) {
                    json(Json {
                            prettyPrint = true
                            isLenient = true
                            useAlternativeNames = true
                            ignoreUnknownKeys
                            explicitNulls = true
                            useArrayPolymorphism = true
                            encodeDefaults = false
                        }
                    )
                }

                install(HttpTimeout) {
                  requestTimeoutMillis = NETWORK_TIMEOUT
                  connectTimeoutMillis = NETWORK_TIMEOUT
                  socketTimeoutMillis = NETWORK_TIMEOUT
                }

                install(Logging) {
                    level = LogLevel.ALL

                }
            }
        }
    }
}