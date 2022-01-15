package com.gowtham.ui_home.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ErrorView(errorStr: String = "Something went wrong!") {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFEFF0F5)
            )
    ) {
        Text(
            text = errorStr,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Button(
            onClick = { /* ... */ },
            elevation = ButtonDefaults.elevation(0.dp, 0.dp),
            contentPadding = PaddingValues(
                horizontal = 18.dp,
                vertical = 12.dp,
            ),
            colors =
            ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            )
        ) {
            Text(
                text = "TRY AGAIN",
                style = MaterialTheme.typography.button,
                color = Color(0xFF35A6FF)
            )
        }
    }
}
