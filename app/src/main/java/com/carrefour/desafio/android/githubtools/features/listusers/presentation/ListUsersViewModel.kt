package com.carrefour.desafio.android.githubtools.features.listusers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrefour.desafio.android.githubtools.core.utils.util.RequestHandler
import com.carrefour.desafio.android.githubtools.core.utils.util.then
import com.carrefour.desafio.android.githubtools.features.listusers.data.mapper.toDomain
import com.carrefour.desafio.android.githubtools.features.listusers.services.ListUsersServices
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListUsersViewModel(private val services: ListUsersServices) : ViewModel() {

    private val _uiState: MutableStateFlow<ListUsersUiStates> =
        MutableStateFlow(ListUsersUiStates.Empty)
    var uiSTate: StateFlow<ListUsersUiStates> = _uiState
    private val pendingActions = MutableSharedFlow<ListUsersEvent>()

    init {
        handleEvents()
    }

    fun onEvent(event: ListUsersEvent) {
        viewModelScope.launch {
            pendingActions.emit(event)
        }
    }

    private fun handleEvents() {
        viewModelScope.launch {
            pendingActions.collect { event ->
                when (event) {
                    ListUsersEvent.OnClickUserEvent -> {}
                    ListUsersEvent.FetchListUsersDataEvent -> fetchListUsersData()
                    else -> {}
                }
            }
        }
    }

    private fun fetchListUsersData() {
        viewModelScope.launch {
            RequestHandler.doRequest { services.fetchListUsersData() }.then(
                onSuccess = {
                    it.toDomain()
                },
                onError = {},
                onFinish = {}
            )
        }
    }
}