package com.carrefour.desafio.android.githubtools.core.components

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.carrefour.desafio.android.githubtools.R
import com.carrefour.desafio.android.githubtools.core.navigation.Screen
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultToolbar(
    title: Int,
    navController: NavHostController,
    menuClick: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }
    val icon = if (showMenu) android.R.drawable.ic_menu_set_as else android.R.drawable.ic_delete

    TopAppBar(
        title = {
            Text(
                stringResource(id = title),
                maxLines = 1,
                style = TextStyle(fontSize = 22.sp),
                color = Color.White,
                overflow = TextOverflow.Ellipsis
            )
        },

        actions = {
            IconButton(onClick = {
                showMenu = true
            }
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = ""
                )
            }
            DropdownMenu(
                modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    onClick = {
                        navController.navigate(Screen.HomeScreen.route)
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_delete),
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    enabled = true,
                    text = {
                        Text(
                            text = "Sair",
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    }
                )

            }

        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}


@OptIn(ExperimentalAnimationApi::class)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PreviewToolbar() {
    val navController = rememberAnimatedNavController()
    val menuClick: () -> Unit = {}
    DefaultToolbar(R.string.app_name, navController, menuClick)
}

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun PreviewToolbarWithSecondIcon() {
    val navController = rememberAnimatedNavController()
    val menuClick: () -> Unit = {}
    DefaultToolbar(R.string.app_name, navController, menuClick)
}