package com.carrefour.desafio.android.githubtools.features.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeEvent
import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeUiStates

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    navController: NavHostController,
    state: HomeUiStates,
    onEvent: (HomeEvent) -> Unit,
    ){

    Scaffold(
        topBar = {

        },
        content = {
            Column(modifier.fillMaxSize()) {
                HomeLayout(it, modifier, navController, state, onEvent)
            }
        }
    )
    LaunchedEffect(Unit){
        onEvent(HomeEvent.FetchHomeData)
    }

}

@Composable
fun HomeLayout(
    paddingValues: PaddingValues,
    modifier: Modifier,
    navController: NavHostController,
    state: HomeUiStates,
    onEvent: (HomeEvent) -> Unit
) {

        Text(text = "HOME SCREEN ")
}
