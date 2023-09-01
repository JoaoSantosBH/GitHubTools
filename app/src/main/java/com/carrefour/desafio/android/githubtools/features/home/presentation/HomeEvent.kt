package com.carrefour.desafio.android.githubtools.features.home.presentation

import com.carrefour.desafio.android.githubtools.features.home.domain.HomeModel

sealed class HomeEvent {
    object FetchHomeData : HomeEvent()
    data class SuccessHomeData(val data: HomeModel) : HomeEvent()

    object DismissDialog : HomeEvent()
    data class UpdateSearchField(val text: String) : HomeEvent()

}
