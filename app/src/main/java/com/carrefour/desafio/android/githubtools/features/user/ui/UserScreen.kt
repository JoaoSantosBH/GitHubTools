package com.carrefour.desafio.android.githubtools.features.user.ui

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
import com.carrefour.desafio.android.githubtools.features.user.presntation.UserEvents
import com.carrefour.desafio.android.githubtools.features.user.presntation.UserUiStates

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    modifier: Modifier,
    navController: NavHostController,
    state: UserUiStates,
    onEvent: (UserEvents) -> Unit,
) {

    Scaffold(
        topBar = {

        },
        content = {
            Column(modifier.fillMaxSize()) {
                UserLayout(it, modifier, navController, state, onEvent)
            }
        }
    )
    LaunchedEffect(Unit) {
        onEvent(UserEvents.FetchUserData)
    }

}

@Composable
fun UserLayout(
    paddingValues: PaddingValues,
    modifier: Modifier,
    navController: NavHostController,
    state: UserUiStates,
    onEvent: (UserEvents) -> Unit
) {

    Text(text = "User SCREEN ")
}

