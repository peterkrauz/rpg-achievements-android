package com.peterkrauz.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.request().let { request ->
        val url = request.url().newBuilder()
            .addQueryParameter("api_key", apiKey)
            .build()

        val newRequest = request.newBuilder()
            .url(url)
            .build()

        chain.proceed(newRequest)
    }
}
