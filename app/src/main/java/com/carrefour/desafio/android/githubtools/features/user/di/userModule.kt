package com.carrefour.desafio.android.githubtools.features.user.di

import com.carrefour.desafio.android.githubtools.features.user.presntation.UserViewModel
import com.carrefour.desafio.android.githubtools.features.user.services.UserServices
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val userModule = module {

    viewModel { UserViewModel(get()) }
    single { provideUserServices(get()) }
}

fun provideUserServices(retrofit: Retrofit): UserServices {
    return retrofit.create(UserServices::class.java)
}