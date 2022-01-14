package com.gowtham.ui_home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gowtham.components.AnnotatedClickableText
import com.gowtham.ui_home.widgets.Toolbar

@Composable
fun HomeScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        Toolbar(isSearch = false)

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen()
}
