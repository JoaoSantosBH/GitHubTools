package com.carrefour.desafio.android.githubtools.core.utils.util

import android.content.Context
import com.carrefour.desafio.android.githubtools.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HttpInterceptor : Interceptor {

    private val accessToken get(): String? = BuildConfig.API_TOKEN


    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val builder = request.newBuilder()

        val token = accessToken

        builder.header("accept","application/json")
        token?.let { builder.header("Authorization", it) }

        return chain.proceed(builder.build())
    }

}