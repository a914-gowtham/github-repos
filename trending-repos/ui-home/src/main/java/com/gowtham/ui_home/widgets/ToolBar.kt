package com.gowtham.ui_home.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.Close
import androidx.compose.material.icons.sharp.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Toolbar(
    isSearch: Boolean,
    onClickListener: (showSearch: Boolean) -> Unit
) {
    TopAppBar(
        elevation = 4.dp,
    ) {

        if (isSearch)
            SearchView(onClickListener)
        else
            AppBarWithSearchOption(onClickListener)

    }
}


@Composable
fun SearchView(onClickListener: (showSearch: Boolean) -> Unit) {

    var searchQuery: String by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onClickListener.invoke(false) }) {
            Icon(
                imageVector = Icons.Sharp.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }

        Box(
            modifier = Modifier.weight(1f)
        ) {

            TextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                },
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(
                            imageVector = Icons.Sharp.Close,
                            contentDescription = "Close",
                            tint = Color.Black
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = false,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth()
            )
            if (searchQuery.isEmpty())
                Text(
                    "Search Repository",
                    color = Color.Black.copy(alpha = 0.4f), modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 10.dp)
                        .wrapContentSize(align = Alignment.Center)
                )
        }

    }
}

@Composable
fun AppBarWithSearchOption(onClickListener: (showSearch: Boolean) -> Unit) {
    Row(
        modifier = Modifier.padding(start = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Trending Repositories",
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            fontSize = 19.sp,
            modifier = Modifier.weight(1f, true)
        )
        IconButton(onClick = {
            onClickListener.invoke(true)
        }) {
            Icon(
                imageVector = Icons.Sharp.Search,
                contentDescription = "Search",
                tint = Color.Black
            )
        }
    }
}