package com.peterkrauz.data

import com.peterkrauz.network.NetworkBuilder

object ServiceFactory {

    val retrofit by lazy {
        // this line here should be made into an interface,
        // and create the NetworkBuilder as an impl inside network module
        NetworkBuilder.buildNetworkClient(BuildConfig.BASE_URL, BuildConfig.DEBUG, BuildConfig.API_KEY)
    }

    inline fun <reified T> createService(): T {
        return retrofit.create(T::class.java)
    }
}