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
import com.gowtham.core.ResultState
import com.gowtham.entities.Repository


@Composable
fun SearchView(
    query: String,
    onClickListener: (showSearch: Boolean) -> Unit,
    queryChange: (query: String) -> Unit
) {

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
                value = query,
                onValueChange = {
                    queryChange(it)
                },
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = {
                        queryChange("")
                    }) {
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
            if (query.isEmpty())
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
fun AppBarWithSearchOption(
    listState: ResultState<List<Repository>>,
    isRefreshing: Boolean,
    onClickListener: (showSearch: Boolean) -> Unit,
) {
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
        if(listState is ResultState.Success)
        IconButton(onClick = {
            if(!isRefreshing)
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