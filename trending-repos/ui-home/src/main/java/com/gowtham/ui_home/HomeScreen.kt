package com.gowtham.ui_home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gowtham.components.AnnotatedClickableText

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        AnnotatedClickableText(title = "Hiii", desc = "Secscs") {

        }
    }

}