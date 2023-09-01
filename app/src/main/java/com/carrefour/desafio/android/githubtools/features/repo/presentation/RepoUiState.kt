package com.carrefour.desafio.android.githubtools.features.repo.presentation

import com.carrefour.desafio.android.githubtools.features.repo.domain.UserReposModel

data class RepoUiState(
    val isLoading:Boolean = false,
    val userLogin:String = "",
    val repoList: List<UserReposModel> = emptyList()
) {
    companion object {
        val Empty = RepoUiState()
    }
}

