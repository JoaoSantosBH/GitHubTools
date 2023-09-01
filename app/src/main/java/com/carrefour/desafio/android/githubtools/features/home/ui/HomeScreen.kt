package com.carrefour.desafio.android.githubtools.features.home.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.carrefour.desafio.android.githubtools.R
import com.carrefour.desafio.android.githubtools.core.components.DefaultToolbar
import com.carrefour.desafio.android.githubtools.core.components.LoadingLayout
import com.carrefour.desafio.android.githubtools.core.components.SearchTextFieldComponent
import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeEvent
import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeUiStates
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    navController: NavHostController,
    state: HomeUiStates,
    onEvent: (HomeEvent) -> Unit,
) {

    Scaffold(
        topBar = {
            DefaultToolbar(title = R.string.app_name, navController = navController) {

            }
        },
        content = {
            Column(
                modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                HomeLayout(it, modifier, navController, state, onEvent)
            }
        }
    )
    LaunchedEffect(Unit) {
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
    Column(
        modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            ) {
        if (state.isLoading)
            LoadingLayout(paddingValues)
        else
            ComponentsLayout(modifier, navController, state, onEvent)
    }
}

@Composable
fun ComponentsLayout(
    modifier: Modifier,
    navController: NavHostController,
    state: HomeUiStates,
    onEvent: (HomeEvent) -> Unit
) {

    LazyColumn {
        item {
            Spacer(modifier.height(62.dp))
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = stringResource(id = R.string.cd_home_logo_text)
                )
            }
        }
        item {
            Spacer(modifier.height(16.dp))
            SearchTextFieldComponent(modifier, onEvent, state)
        }
        item {
            Spacer(modifier.height(16.dp))
            HomeSearchButton(navController, state, R.string.btn_search_txt, "SearchButtonTag")
        }
        item {
            Spacer(modifier.height(16.dp))
            HomeAllUsersButton(navController, state, R.string.btn_list_all_txt, "ListAllButtonTag")
            Spacer(modifier.height(62.dp))
        }

    }

}

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun ComponentsPreview() {
    val modifier = Modifier
    val navController = rememberAnimatedNavController()
    val state = HomeUiStates.Empty
    val onEvent: (HomeEvent) -> Unit = {}
    ComponentsLayout(modifier, navController, state, onEvent)
}
