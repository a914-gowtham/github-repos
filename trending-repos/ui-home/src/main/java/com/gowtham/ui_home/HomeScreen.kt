package com.gowtham.ui_home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gowtham.ui_home.widgets.ErrorView
import com.gowtham.ui_home.widgets.LoadingView
import com.gowtham.ui_home.widgets.Toolbar


@Composable
fun HomeScreen() {

    var isSearchView: Boolean by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Toolbar(isSearch = isSearchView) {
                isSearchView = it
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        ErrorView()
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingStatePreview() {
    LoadingView()
}


@Preview(showBackground = true)
@Composable
fun ErrorStatePreview() {
    ErrorView()
}
