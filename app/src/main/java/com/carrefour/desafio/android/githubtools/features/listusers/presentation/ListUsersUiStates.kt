package com.carrefour.desafio.android.githubtools.features.listusers.presentation

import com.carrefour.desafio.android.githubtools.features.listusers.domain.ListUsersModel

data class ListUsersUiStates(
    val isLoading: Boolean = false,
    val list: List<ListUsersModel> = emptyList()
) {
    companion object {
        val Empty = ListUsersUiStates()
        val DUMB_LIST = listOf(
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
            ListUsersModel(login = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
        )
    }
}
