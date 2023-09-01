package com.carrefour.desafio.android.githubtools.features.user.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.carrefour.desafio.android.githubtools.R
import com.carrefour.desafio.android.githubtools.core.components.DefaultToolbar
import com.carrefour.desafio.android.githubtools.core.components.LoadingLayout
import com.carrefour.desafio.android.githubtools.core.navigation.Screen
import com.carrefour.desafio.android.githubtools.features.user.presntation.UserEvents
import com.carrefour.desafio.android.githubtools.features.user.presntation.UserUiStates
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

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
            DefaultToolbar(title = R.string.app_name, navController = navController) {
            }
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
                    UserLayout(paddingValues, modifier, navController, state, onEvent)
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

    Spacer(modifier.height(72.dp))
    LazyColumn(modifier.padding(horizontal = 16.dp)) {
        item {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://avatars.githubusercontent.com/u/1?v=4")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_logo),
                error = painterResource(R.drawable.ic_logo),
                contentDescription = "Mocked"
            )
            Spacer(modifier.height(16.dp))
        }

        item {
            Row(modifier.fillMaxWidth()) {
                Text(text = "qwerqwerqwerqwerqwerqwerqwerqwer\nqwerqwerqwerqwerqwerqwerqer")
            }
            Spacer(modifier.height(80.dp))
        }

        item {
            UserButtonComponent(state = state, btnText = R.string.repo_list_text, testTag = "UserBtnText")
        }
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun PreviewUserPage() {
    val modifier = Modifier
    val navController = rememberAnimatedNavController()
    val state = UserUiStates.Empty
    val onEvent: (UserEvents) -> Unit = {}
    UserLayout(
        paddingValues = PaddingValues(),
        modifier = modifier,
        navController = navController, state = state, onEvent = onEvent
    )
}

