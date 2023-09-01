package com.carrefour.desafio.android.githubtools.core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.carrefour.desafio.android.githubtools.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnotherToolbarComposable(
    navController: NavHostController,
) {

    TopAppBar( modifier = Modifier
        .height(88.dp)
        .fillMaxWidth(),
        title = { Text(text = stringResource(id = R.string.app_name)) },
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() } ,
                enabled = true,
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_delete),
                    contentDescription = ""
                )
            }
        }
    )

}