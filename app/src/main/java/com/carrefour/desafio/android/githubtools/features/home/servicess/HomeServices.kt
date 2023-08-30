package com.carrefour.desafio.android.githubtools.features.home.servicess

import com.carrefour.desafio.android.githubtools.core.utils.util.NetworkUtils.Companion.BASE_URL
import com.carrefour.desafio.android.githubtools.features.home.data.remote.model.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeServices {

    @GET(BASE_URL)
    suspend fun fetchHomeData(): Response<HomeResponse>


}