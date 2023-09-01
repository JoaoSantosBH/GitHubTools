package com.carrefour.desafio.android.githubtools.core.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.carrefour.desafio.android.githubtools.R
import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeEvent
import com.carrefour.desafio.android.githubtools.features.home.presentation.HomeUiStates

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextFieldComponent(
    modifier: Modifier,
    onEvent: (HomeEvent) -> Unit,
    state: HomeUiStates
) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {

        OutlinedTextField(
            value = state.searchText,
            onValueChange = {
                text = it
                onEvent(HomeEvent.UpdateSearchField(it))
                            },
            modifier.fillMaxWidth(),
            singleLine = true,
            trailingIcon =
            {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(android.R.drawable.ic_menu_search),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            },
            label = { Text(stringResource(id = R.string.search_field_hint)) },

            )
    }

}

