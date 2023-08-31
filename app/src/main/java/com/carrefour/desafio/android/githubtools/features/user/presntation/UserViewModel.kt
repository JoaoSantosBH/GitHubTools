package com.carrefour.desafio.android.githubtools.features.user.presntation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrefour.desafio.android.githubtools.core.utils.util.RequestHandler
import com.carrefour.desafio.android.githubtools.core.utils.util.then
import com.carrefour.desafio.android.githubtools.features.user.data.remote.mapper.toDomain
import com.carrefour.desafio.android.githubtools.features.user.services.UserServices
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val services: UserServices) : ViewModel() {

    private val _uiState: MutableStateFlow<UserUiStates> = MutableStateFlow(UserUiStates.Empty)
    var uiState: StateFlow<UserUiStates> = _uiState.asStateFlow()
    private val pendingActions = MutableSharedFlow<UserEvents>()

    init {
        handleEvents()
    }

    fun onEvent(event: UserEvents) {
        viewModelScope.launch {
            pendingActions.emit(event)
        }
    }

    private fun handleEvents() {
        viewModelScope.launch {
            pendingActions.collect { event ->
                when (event) {
                    UserEvents.FetchUserData -> {  fetchUserData("mojombo")}
                    else -> {}
                }

            }
        }
    }

    private fun fetchUserData(login: String) {
        viewModelScope.launch {
            RequestHandler.doRequest { services.fetchUserData(login) }.then(
                onSuccess = {
                    it.toDomain()
                },
                onError = {},
                onFinish = {}
            )
        }
    }
}