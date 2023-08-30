package com.carrefour.desafio.android.githubtools.core.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object UserScreen : Screen("user")
    object UserReposScreen : Screen("repos")

    object AllUsersList : Screen("all")
}