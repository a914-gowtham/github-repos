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


@Composable
fun RepoRow() {
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
                    data = "https://avatars.githubusercontent.com/u/82592?s=200&v=4",
                    imageLoader = LocalImageLoader.current,
                    builder = {
                        crossfade(
                            durationMillis = 400
                        )
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
                text = "square",
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
            text = "bionic",
            style = MaterialTheme.typography.h6,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 2.dp)
        )
        Text(
            text = "A python framework for data science",
            style = MaterialTheme.typography.subtitle1,
            color = Color.Black,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                tint = Color(0xFFFFDE03)
            )
            Text(
                text = "Python",
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
                text = "44",
                style = MaterialTheme.typography.subtitle1,
                color = Color.Gray,
                modifier = Modifier.padding(start = 6.dp)
            )
        }

        Divider(modifier = Modifier.padding(top = 8.dp))
    }
}