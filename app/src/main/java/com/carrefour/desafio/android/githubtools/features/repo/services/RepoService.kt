package com.carrefour.desafio.android.githubtools.features.repo.services

import com.carrefour.desafio.android.githubtools.core.utils.util.NetworkUtils
import com.carrefour.desafio.android.githubtools.features.repo.data.remote.model.UserReposResponse
import com.carrefour.desafio.android.githubtools.features.user.data.remote.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoService {

    //https://api.github.com/users/mojombo/repos

    @GET(NetworkUtils.USER_REPOS)
    suspend fun fetchUserReposData(
        @Path("user") user: String,
        @Query("page") page: Int
    ): Response<List<UserReposResponse>>
}