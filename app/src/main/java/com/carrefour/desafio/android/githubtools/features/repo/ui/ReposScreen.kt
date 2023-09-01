package com.carrefour.desafio.android.githubtools.features.repo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.carrefour.desafio.android.githubtools.core.components.AnotherToolbarComposable
import com.carrefour.desafio.android.githubtools.core.components.LoadingLayout
import com.carrefour.desafio.android.githubtools.core.navigation.Screen
import com.carrefour.desafio.android.githubtools.features.repo.domain.UserReposModel
import com.carrefour.desafio.android.githubtools.features.repo.presentation.RepoUiState
import com.carrefour.desafio.android.githubtools.features.repo.presentation.ReposEvents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReposScreen(
    modifier: Modifier,
    navController: NavHostController,
    state: RepoUiState,
    onEvent: (ReposEvents) -> Unit

) {

    Scaffold(
        topBar = { AnotherToolbarComposable(navController = navController) },
        content = { paddingValues ->
            Column(
                modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .clickable { navController.navigate(Screen.AllUsersList.route) }) {
                if (state.isLoading)
                    LoadingLayout(paddingValues)
                else
                    ReposLayout(paddingValues, modifier, navController, state, onEvent)

            }
        }
    )
    LaunchedEffect(Unit) {
        onEvent(ReposEvents.FetchUserReposEvent)
    }
}

@Composable
fun ReposLayout(
    paddingValues: PaddingValues,
    modifier: Modifier,
    navController: NavController,
    state: RepoUiState,
    onEvent: (ReposEvents) -> Unit
) {
    Spacer(modifier.height(8.dp))

    LazyColumn(modifier.padding(paddingValues)) {

        items(state.repoList) { item ->
            ItemListRepoComponent(item)
        }
    }
}

@Composable
fun ItemListRepoComponent(item: UserReposModel) {
    Card(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.Start ,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = item.fullName.toString(), style = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }
    }
}
