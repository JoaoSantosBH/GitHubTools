package com.carrefour.desafio.android.githubtools.features.listusers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrefour.desafio.android.githubtools.core.utils.util.RequestHandler
import com.carrefour.desafio.android.githubtools.core.utils.util.then
import com.carrefour.desafio.android.githubtools.core.utils.util.update
import com.carrefour.desafio.android.githubtools.features.listusers.data.remote.mapper.toDomain
import com.carrefour.desafio.android.githubtools.features.listusers.services.ListUsersServices
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListUsersViewModel(private val services: ListUsersServices) : ViewModel() {

    private val _uiState: MutableStateFlow<ListUsersUiStates> =
        MutableStateFlow(ListUsersUiStates.Empty)
    var uiSTate: StateFlow<ListUsersUiStates> = _uiState.asStateFlow()
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
            _uiState.update { it.copy(isLoading = true) }
            RequestHandler.doRequest { services.fetchListUsersData() }.then(
                onSuccess = { result ->
                    _uiState.update { it.copy(list = result.toDomain()) }
                },
                onError = {
                    _uiState.update { it.copy(isLoading = false) }

                },
                onFinish = {
                    _uiState.update { it.copy(isLoading = false) }

                }
            )
        }
    }
}