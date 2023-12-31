package com.carrefour.desafio.android.githubtools.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrefour.desafio.android.githubtools.core.utils.util.RequestHandler
import com.carrefour.desafio.android.githubtools.core.utils.util.then
import com.carrefour.desafio.android.githubtools.features.home.data.remote.mapper.toDomain
import com.carrefour.desafio.android.githubtools.features.home.servicess.HomeServices
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val services: HomeServices
) : ViewModel() {
    private val _uiState: MutableStateFlow<HomeUiStates> =
        MutableStateFlow(HomeUiStates.Empty)
    var uiSTate: StateFlow<HomeUiStates> = _uiState.asStateFlow()
    private val pendingActions = MutableSharedFlow<HomeEvent>()

    init {
        handleEvents()
    }
    fun onEvent(event: HomeEvent) {
        viewModelScope.launch {
            pendingActions.emit(event)
        }
    }

    private fun handleEvents() {
        viewModelScope.launch {
            pendingActions.collect { event ->
                when (event) {
                    is HomeEvent.UpdateSearchField -> updateSearchField(event.text)
                    HomeEvent.DismissDialog -> dismissErrorMessage()
                    HomeEvent.FetchHomeData -> fetchHome()
                    else -> {}
                }
            }
        }
    }

    private fun updateSearchField(text: String) {
        _uiState.update { it.copy(searchText = text) }
    }

    fun fetchHome(){
        viewModelScope.launch {
            RequestHandler.doRequest { services.fetchHomeData() }.then(
                onSuccess = { response ->
                    response.toDomain()
                },
                onError = {
                    //TODO
                },
                onFinish = {
                    //TODO
                }
            )
        }
    }
    private fun dismissErrorMessage() {
    }
}