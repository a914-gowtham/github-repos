package com.gowtham.ui_home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import com.gowtham.components.CircleShape
import com.gowtham.components.Utils.color
import com.gowtham.core.Utils
import com.gowtham.entities.Repository


@Composable
fun RepoRowView(repo: Repository, json: String?) {

    val languageHexColor = Utils.getLanguageHexColor(
        repo.language,
        json
    )
    Column(
        Modifier
            .background(Color.White)
            .padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(
                    data = repo.avatar,
                    imageLoader = LocalImageLoader.current,
                    builder = {
                        crossfade(
                            durationMillis = 400
                        )
                        placeholder(0)
                    }
                ),
                contentDescription = "Image",
                modifier = Modifier
                    .size(18.dp)
                    .padding(
                        top = 3.dp
                    )
            )
            Text(
                text = repo.ownerName,
                style = MaterialTheme.typography.body1,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(start = 6.dp)
                    .wrapContentSize(
                        align = Alignment.Center
                    )
            )
        }
        Text(
            text = repo.name,
            style = MaterialTheme.typography.h6,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 2.dp)
        )
        Text(
            text = repo.description,
            style = MaterialTheme.typography.subtitle1,
            color = Color.Black,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            CircleShape(
                size = 14, color = languageHexColor.color
            )
            Text(
                text = repo.language,
                style = MaterialTheme.typography.subtitle1,
                color = Color.Gray,
                modifier = Modifier.padding(start = 6.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                tint = Color(0xFFFFDE03)
            )
            Text(
                text = repo.starsCount.toString(),
                style = MaterialTheme.typography.subtitle1,
                color = Color.Gray,
                modifier = Modifier.padding(start = 6.dp)
            )
        }

        Divider(modifier = Modifier.padding(top = 8.dp))
    }
}