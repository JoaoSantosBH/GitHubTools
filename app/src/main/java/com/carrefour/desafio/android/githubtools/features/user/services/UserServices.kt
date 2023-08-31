package com.carrefour.desafio.android.githubtools.features.user.services

import com.carrefour.desafio.android.githubtools.core.utils.util.NetworkUtils
import com.carrefour.desafio.android.githubtools.features.user.data.remote.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserServices {

    @GET(NetworkUtils.USER_ENDPOINT)
    suspend fun fetchUserData(
        @Path("user") user: String
    ): Response<UserResponse>

}