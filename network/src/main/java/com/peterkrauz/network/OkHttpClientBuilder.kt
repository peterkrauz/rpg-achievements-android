package com.peterkrauz.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

internal object OkHttpClientBuilder {

    fun build(debug: Boolean, apiKey: String): OkHttpClient {
        val httpLoginInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        val clientBuilder = OkHttpClient.Builder().apply {
            addInterceptor(AuthenticationInterceptor(apiKey))
        }

        if (debug) {
            httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoginInterceptor)
        }

        return clientBuilder.build()
    }
}
