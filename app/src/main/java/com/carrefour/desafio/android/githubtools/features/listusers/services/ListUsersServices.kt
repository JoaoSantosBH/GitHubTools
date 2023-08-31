package com.carrefour.desafio.android.githubtools.features.listusers.services

import com.carrefour.desafio.android.githubtools.core.utils.util.NetworkUtils
import com.carrefour.desafio.android.githubtools.features.listusers.data.remote.model.ListUsersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ListUsersServices {

    @GET(NetworkUtils.LIST_USERS_ENDPOINT)
    suspend fun fetchListUsersData(): Response<List<ListUsersResponse>>

}