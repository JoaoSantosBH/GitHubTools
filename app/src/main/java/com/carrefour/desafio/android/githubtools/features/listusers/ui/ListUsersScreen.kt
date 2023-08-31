package com.carrefour.desafio.android.githubtools.features.listusers.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.carrefour.desafio.android.githubtools.core.navigation.Screen
import com.carrefour.desafio.android.githubtools.features.listusers.presentation.ListUsersEvent
import com.carrefour.desafio.android.githubtools.features.listusers.presentation.ListUsersUiStates

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListUsersScreen(
    modifier: Modifier,
    navController: NavHostController,
    state: ListUsersUiStates,
    onEvent: (ListUsersEvent) -> Unit,
) {

    Scaffold(
        topBar = {

        },
        content = {
            Column(modifier.fillMaxSize()) {
                ListUsersLayout(it, modifier, navController, state, onEvent)
            }
        }
    )
    LaunchedEffect(Unit) {
        onEvent(ListUsersEvent.FetchListUsersDataEvent)
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

    Column(modifier.fillMaxSize().clickable { navController.navigate(Screen.UserScreen.route) }) {
        Text(text = "ListUsers SCREEN ")
    }
}