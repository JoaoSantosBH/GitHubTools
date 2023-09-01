package com.carrefour.desafio.android.githubtools.features.home.presentation

data class HomeUiStates(
    val isLoading:Boolean = false,
    val searchText:String = ""
) {
    companion object {
        val Empty =  HomeUiStates()
    }

}
