package com.carrefour.desafio.android.githubtools.core.di

import com.carrefour.desafio.android.githubtools.core.utils.util.HttpInterceptor
import com.carrefour.desafio.android.githubtools.core.utils.util.NetworkUtils.Companion.BASE_URL
import com.carrefour.desafio.android.githubtools.core.utils.util.provideCache
import com.carrefour.desafio.android.githubtools.core.utils.util.provideOkHttpClient
import com.carrefour.desafio.android.githubtools.core.utils.util.provideRetrofit
import com.carrefour.desafio.android.githubtools.features.home.di.provideHomeServices
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val mainModule = module {

    single { HttpInterceptor(get()) }
    single { provideHomeServices(get()) }
    single { provideCache(androidApplication()) }
    single { provideOkHttpClient( get(), androidContext(), get()) }
    single { provideRetrofit(BASE_URL,  get()) }
}