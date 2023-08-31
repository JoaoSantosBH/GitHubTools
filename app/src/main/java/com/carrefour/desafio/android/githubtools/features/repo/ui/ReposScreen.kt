package com.carrefour.desafio.android.githubtools.features.repo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.carrefour.desafio.android.githubtools.features.listusers.ui.ListUsersLayout
import com.carrefour.desafio.android.githubtools.features.repo.presentation.RepoUiState
import com.carrefour.desafio.android.githubtools.features.repo.presentation.ReposEvents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReposScreen(
    modifier: Modifier,
    navController: NavController,
    state: RepoUiState,
    onEvent: (ReposEvents) -> Unit

) {

    Scaffold(
        topBar = {},
        content = {paddin ->
            Column(modifier.fillMaxSize()) {
                ReposLayout(paddin, modifier, navController, state, onEvent)
            }
        }
    )
    LaunchedEffect(Unit){
        onEvent(ReposEvents.FetchUserReposEvent)
    }
}

@Composable
fun ReposLayout(
    paddin: PaddingValues,
    modifier: Modifier,
    navController: NavController,
    state: RepoUiState,
    onEvent: (ReposEvents) -> Unit
) {
    Text("REPOS LAYOUT")
}
