package com.gowtham.ui_home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.gowtham.core.ResultState
import com.gowtham.ui_home.widgets.*


@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
) {

    val listState = viewModel.listState.collectAsState()
    val isRefreshing by viewModel.refreshState.collectAsState()
    val isSearchView by viewModel.isSearchOpened.collectAsState()
    val searchQuery by viewModel.lastQuery.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
            ) {
                if (isSearchView)
                    SearchView(searchQuery, onClickListener = {
                        viewModel.showSearchView(it)
                    }) {
                        viewModel.queryRepo(it.trim())
                    }
                else
                    AppBarWithSearchOption(
                        listState = listState.value,
                        isRefreshing = isRefreshing
                    ) {
                        viewModel.showSearchView(it)
                    }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        if (listState.value is ResultState.Loading)
            LoadingView()
        if (listState.value is ResultState.Failure) {
            val errorState = listState.value as ResultState.Failure
            ErrorView(errorStr = errorState.message, viewModel = viewModel)
        }
        if (listState.value is ResultState.Success) {
            val state = listState.value as ResultState.Success
            val repoList = state.data
            SwipeRefresh(
                swipeEnabled = !isSearchView,
                state = rememberSwipeRefreshState(isRefreshing),
                onRefresh = { viewModel.refreshRepoList() },
                indicator = { s, trigger ->
                    SwipeRefreshIndicator(s, trigger, backgroundColor = Color.Blue)
                }
            ) {
                LazyColumn(contentPadding = it) {
                    items(repoList) { repo ->
                        RepoRowView(repo)
                    }
                }
            }
        }
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
