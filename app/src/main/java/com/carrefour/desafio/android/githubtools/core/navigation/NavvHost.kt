package com.carrefour.desafio.android.githubtools.core.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.carrefour.desafio.android.githubtools.core.utils.util.rememberFlowWithLifecycle
import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeUiStates
import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeViewModel
import com.carrefour.desafio.android.githubtools.features.home.ui.HomeScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import org.koin.androidx.compose.getViewModel


@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        modifier = modifier,
    ) {
        navigateToHome(navController, modifier)
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.navigateToHome(navController: NavHostController, modifier: Modifier) {
    composable(route = Screen.HomeScreen.route) {
        val viewModel: HomeViewModel = getViewModel()
        val uiState by rememberFlowWithLifecycle(viewModel.uiSTate)
            .collectAsState(initial = HomeUiStates.Empty)
        HomeScreen(
            modifier = modifier,
            navController = navController,
            state = uiState,
            onEvent = viewModel::onEvent
        )
    }
}




