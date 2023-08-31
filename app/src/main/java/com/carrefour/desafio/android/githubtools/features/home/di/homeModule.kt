package com.carrefour.desafio.android.githubtools.features.home.di

import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeViewModel
import com.carrefour.desafio.android.githubtools.features.home.servicess.HomeServices
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val homeModule = module {

    viewModel { HomeViewModel(get()) }
    single { provideHomeServices(get()) }


}

fun provideHomeServices(retrofit: Retrofit): HomeServices {
    return retrofit.create(HomeServices::class.java)
}