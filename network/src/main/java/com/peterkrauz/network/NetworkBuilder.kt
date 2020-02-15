package com.peterkrauz.network

import retrofit2.Retrofit

object NetworkBuilder {

    fun buildNetworkClient(baseUrl: String, debug: Boolean, apiKey: String): Retrofit {
        return RetrofitBuilder
            .build(baseUrl, OkHttpClientBuilder.build(debug, apiKey))
    }
}
