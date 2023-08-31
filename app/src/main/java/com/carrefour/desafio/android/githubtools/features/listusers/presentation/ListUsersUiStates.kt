package com.carrefour.desafio.android.githubtools.features.listusers.presentation

data class ListUsersUiStates(
    val isLoading: Boolean = false
) {
    companion object {
     val Empty = ListUsersUiStates()
    }
}
