package com.gowtham.ui_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gowtham.core.ResultState
import com.gowtham.entities.Repository
import com.gowtham.usecases.RepoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: RepoUseCases
) : ViewModel() {

    private val _trendingRepoList =
        MutableStateFlow<ResultState<List<Repository>>>(ResultState.Idle)
    val listState: StateFlow<ResultState<List<Repository>>>
        get() = _trendingRepoList

    private val _refreshState =
        MutableStateFlow(false)
    val refreshState: StateFlow<Boolean>
        get() = _refreshState

    private val _isSearchOpened =
        MutableStateFlow(false)
    val isSearchOpened: StateFlow<Boolean>
        get() = _isSearchOpened

    private val _lastQuery =
        MutableStateFlow("")
    val lastQuery: StateFlow<String>
        get() = _lastQuery

    init {
        fetchRepoList()
    }

    fun fetchRepoList() {
        if (_trendingRepoList.value is ResultState.Loading)
            return
        _trendingRepoList.value = ResultState.Loading
        viewModelScope.launch {
            _trendingRepoList.value = useCases.getRepos.execute(refresh = false)
        }
    }

    fun refreshRepoList() {
        if (_refreshState.value)
            return
        _refreshState.value = true
        viewModelScope.launch {
            _trendingRepoList.value = useCases.getRepos.execute(refresh = true)
            _refreshState.value = false
        }
    }

    fun queryRepo(query: String) {
        _lastQuery.value= query
        if (query.isEmpty()) {
            _trendingRepoList.value = ResultState.Success(emptyList())
        }else {
            viewModelScope.launch {
                _trendingRepoList.value = useCases.searchRepoUseCase.execute(query)
            }
        }
    }

    fun showSearchView(show: Boolean){
        _isSearchOpened.value= show
        if(show)
            queryRepo("")
        else
          fetchRepoList()
    }
}