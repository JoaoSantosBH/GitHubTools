package com.carrefour.desafio.android.githubtools.features.listusers.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.carrefour.desafio.android.githubtools.features.listusers.domain.ListUsersModel
import com.carrefour.desafio.android.githubtools.features.listusers.presentation.ListUsersUiStates

@Composable
fun ItemListComponent(item: ListUsersModel) {
    Card(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                Modifier.width(80.dp),
                horizontalAlignment = Alignment.Start
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(100.dp)),
                    contentScale = ContentScale.Crop,
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.avatarUrl)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(android.R.drawable.ic_menu_upload),
                    error = painterResource(android.R.drawable.ic_delete),
                    contentDescription = item.login
                )
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.Start ,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "ert", style = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewList(){
    ItemListComponent(
        ListUsersModel(
            login = "mojombo",
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"))
}