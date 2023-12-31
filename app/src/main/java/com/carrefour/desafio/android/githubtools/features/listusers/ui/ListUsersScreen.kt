package com.carrefour.desafio.android.githubtools.features.listusers.ui

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.carrefour.desafio.android.githubtools.core.components.AnotherToolbarComposable
import com.carrefour.desafio.android.githubtools.core.components.DefaultToolbar
import com.carrefour.desafio.android.githubtools.core.components.LoadingLayout
import com.carrefour.desafio.android.githubtools.core.navigation.Screen
import com.carrefour.desafio.android.githubtools.features.listusers.presentation.ListUsersEvent
import com.carrefour.desafio.android.githubtools.features.listusers.presentation.ListUsersUiStates
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListUsersScreen(
    modifier: Modifier,
    navController: NavHostController,
    state: ListUsersUiStates,
    onEvent: (ListUsersEvent) -> Unit,
) {
    val scaffoldState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            AnotherToolbarComposable(navController = navController)
        },
        content = { paddingValues ->
            Column(
                modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .clickable { navController.navigate(Screen.AllUsersList.route) }) {
                if (state.isLoading)
                    LoadingLayout(paddingValues)
                else
                    ListUsersLayout(paddingValues, modifier, navController, state, onEvent)

            }
        }
    )
    LaunchedEffect(Unit) {
        onEvent(ListUsersEvent.FetchListUsersDataEvent)
        if (state.isError) {
            coroutineScope.launch {
                scaffoldState.showSnackbar(
                    message = state.errorMessage,
                )
            }
        }
    }
    SideEffect() {

    }

}

@Composable
fun ListUsersLayout(
    paddingValues: PaddingValues,
    modifier: Modifier,
    navController: NavHostController,
    state: ListUsersUiStates,
    onEvent: (ListUsersEvent) -> Unit
) {

    Spacer(modifier.height(8.dp))

    LazyColumn(modifier.padding(paddingValues)) {

        items(state.list) { cardItem ->
            ItemListComponent(item = cardItem, navController)
            Spacer(modifier = Modifier.height(4.dp))
        }

    }

}

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun ComponentsPreview() {
    val modifier = Modifier
    val navController = rememberAnimatedNavController()
    val state = ListUsersUiStates.Empty
    val onEvent: (ListUsersEvent) -> Unit = {}
    ListUsersLayout(PaddingValues(), modifier, navController, state, onEvent)
}