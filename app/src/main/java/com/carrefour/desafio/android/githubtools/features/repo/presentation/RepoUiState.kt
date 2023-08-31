package com.carrefour.desafio.android.githubtools.features.repo.presentation

data class RepoUiState(
    val isLoading:Boolean = false
) {
    companion object {
        val Empty = RepoUiState()
    }
}

