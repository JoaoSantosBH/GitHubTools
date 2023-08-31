package com.carrefour.desafio.android.githubtools.core.utils.util

class NetworkUtils {
    companion object {
        const val BASE_URL = "https://api.github.com/"
        const val USERS_ENDPOINT = "users"
        const val LIST_USERS_ENDPOINT = BASE_URL + USERS_ENDPOINT
        const val USER_ENDPOINT = BASE_URL+ "users/{user}"
        const val USER_REPOS = USER_ENDPOINT + "/repos"


    }
}