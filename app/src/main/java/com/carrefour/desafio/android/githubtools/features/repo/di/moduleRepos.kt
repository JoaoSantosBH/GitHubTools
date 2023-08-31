package com.carrefour.desafio.android.githubtools.features.repo.di

import com.carrefour.desafio.android.githubtools.features.repo.presentation.UserRepoViewModel
import com.carrefour.desafio.android.githubtools.features.repo.services.RepoService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val moduleRepos = module {

    viewModel { UserRepoViewModel(get()) }
    single { provideReposServices(get()) }
}

fun provideReposServices(retrofit: Retrofit): RepoService {
    return retrofit.create(RepoService::class.java)
}