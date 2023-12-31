package com.carrefour.desafio.android.githubtools.core.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.carrefour.desafio.android.githubtools.core.utils.util.USER_LOGIN
import com.carrefour.desafio.android.githubtools.core.utils.util.USER_LOGIN_ARGS
import com.carrefour.desafio.android.githubtools.core.utils.util.rememberFlowWithLifecycle
import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeUiStates
import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeViewModel
import com.carrefour.desafio.android.githubtools.features.home.ui.HomeScreen
import com.carrefour.desafio.android.githubtools.features.listusers.presentation.ListUsersUiStates
import com.carrefour.desafio.android.githubtools.features.listusers.presentation.ListUsersViewModel
import com.carrefour.desafio.android.githubtools.features.listusers.ui.ListUsersScreen
import com.carrefour.desafio.android.githubtools.features.repo.presentation.RepoUiState
import com.carrefour.desafio.android.githubtools.features.repo.presentation.UserRepoViewModel
import com.carrefour.desafio.android.githubtools.features.repo.ui.ReposScreen
import com.carrefour.desafio.android.githubtools.features.user.presntation.UserUiStates
import com.carrefour.desafio.android.githubtools.features.user.presntation.UserViewModel
import com.carrefour.desafio.android.githubtools.features.user.ui.UserScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import kotlinx.coroutines.flow.collectIndexed
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
        navigateToAllUsersSccreen(navController, modifier)
        navigateToUser(navController, modifier)
        navigateToUserRepos(navController, modifier)
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

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.navigateToAllUsersSccreen(
    navController: NavHostController,
    modifier: Modifier
) {
    composable(route = Screen.AllUsersList.route) {
        val viewModel: ListUsersViewModel = getViewModel()
        val uiState by rememberFlowWithLifecycle(viewModel.uiSTate)
            .collectAsState(initial = ListUsersUiStates.Empty)
        ListUsersScreen(
            modifier = modifier,
            navController = navController,
            state = uiState,
            onEvent = viewModel::onEvent
        )
    }

}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.navigateToUser(
    navController: NavHostController,
    modifier: Modifier
) {
    composable(
        route = Screen.UserScreen.route + USER_LOGIN_ARGS,
        arguments = listOf(navArgument(USER_LOGIN) {type = NavType.StringType }  )) { backStackEntry ->

        val viewModel: UserViewModel = getViewModel()
        viewModel.setUserLogin(backStackEntry.arguments?.getString(USER_LOGIN).toString())
        val uiState by rememberFlowWithLifecycle(viewModel.uiState)
            .collectAsState(initial = UserUiStates.Empty)
        UserScreen(
            modifier = modifier,
            navController = navController,
            state = uiState,
            onEvent = viewModel::onEvent
        )
    }
}
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.navigateToUserRepos(
    navController: NavHostController,
    modifier: Modifier
) {
    composable(
        route = Screen.UserReposScreen.route + USER_LOGIN_ARGS,
        arguments = listOf(navArgument(USER_LOGIN) { type = NavType.StringType })) { backStackEntry ->

        val viewModel: UserRepoViewModel = getViewModel()
        viewModel.setUserLogin(backStackEntry.arguments?.getString(USER_LOGIN).toString())
        val uiState by rememberFlowWithLifecycle(viewModel.uiState)
            .collectAsState(initial = RepoUiState.Empty)
        ReposScreen(modifier = modifier, navController = navController, state = uiState, onEvent = viewModel::onEvent )
    }
}




