package com.carrefour.desafio.android.githubtools.features.listusers.di

import com.carrefour.desafio.android.githubtools.features.listusers.presentation.ListUsersViewModel
import com.carrefour.desafio.android.githubtools.features.listusers.services.ListUsersServices
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val listUsersModule = module {

    viewModel { ListUsersViewModel(get()) }
    single { provideListUsersServices(get()) }

}

fun provideListUsersServices(retrofit: Retrofit): ListUsersServices {
    return retrofit.create(ListUsersServices::class.java)
}