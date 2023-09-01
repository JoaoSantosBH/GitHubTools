package com.carrefour.desafio.android.githubtools.features.repo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrefour.desafio.android.githubtools.core.utils.util.RequestHandler
import com.carrefour.desafio.android.githubtools.core.utils.util.then
import com.carrefour.desafio.android.githubtools.core.utils.util.update
import com.carrefour.desafio.android.githubtools.features.repo.data.remote.mapper.toDomain
import com.carrefour.desafio.android.githubtools.features.repo.services.RepoService
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserRepoViewModel(
    private val services: RepoService
) : ViewModel() {

    private val _uiState: MutableStateFlow<RepoUiState> = MutableStateFlow(RepoUiState.Empty)
    var uiState: StateFlow<RepoUiState> = _uiState.asStateFlow()
    private val pendingActions = MutableSharedFlow<ReposEvents>()

    init {
        handleEvents()
    }

    private fun handleEvents() {
        viewModelScope.launch {
            pendingActions.collect { event ->
                when (event) {
                    ReposEvents.FetchUserReposEvent -> fetchUserRepos()
                }
            }
        }
    }

    fun onEvent(event: ReposEvents) {
        viewModelScope.launch {
            pendingActions.emit(event)
        }
    }

    private fun fetchUserRepos() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            RequestHandler.doRequest { services.fetchUserReposData(uiState.value.userLogin, 1) }
                .then(
                    onSuccess = { result ->
                        _uiState.update { it.copy(repoList = result.toDomain()) }
                    },
                    onError = {
                        _uiState.update { it.copy(isLoading = false) }
                    },
                    onFinish = { _uiState.update { it.copy(isLoading = false) } }
                )
        }
    }

    fun setUserLogin(login: String) {
        _uiState.update { it.copy(userLogin = login) }
    }

}