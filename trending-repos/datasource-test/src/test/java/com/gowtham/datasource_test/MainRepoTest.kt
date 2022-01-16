package com.gowtham.datasource_test

import com.google.common.truth.Truth.assertThat
import com.gowtham.lib.MainRepo
import com.gowtham.lib.MainRepoImpl
import com.gowtham.lib.cache.GithubDatabase
import com.gowtham.lib.remote.ApiService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.*
import retrofit2.Response

class MainRepoTest {

    private lateinit var mainRepo: MainRepo

    private val apiService: ApiService = mock()

    private val database: GithubDatabase = mock()

    @get:Rule
    var coroutinesRule = MainCoroutinesRule()


    @Before
    fun setup() {
        mainRepo = MainRepoImpl(cache = database, remote = apiService)
    }

    @Test
    fun getRepoListTest() = runBlocking {
        val mockData = MockUtil.mockRepoList()
        whenever(mainRepo.selectAll()).thenReturn(
            mockData
        )

        val repoList = mainRepo.getRepoList(isRefresh = false)

        assertThat(repoList).hasSize(1)
        assertThat(repoList).contains(mockData.first())
        verify(mainRepo, atLeastOnce()).selectAll()

        Unit
    }


    @Test
    fun getRepoListRefreshTest() = runBlocking {
        val mockData = MockUtil.mockApiRepoList()
        whenever(apiService.getRepoList()).thenReturn(
            Response.success(mockData)
        )
        whenever(mainRepo.getStarGazers("","")).thenReturn(
            22
        )
        whenever(mainRepo.getLanguages("","")).thenReturn(
            ""
        )

        val repoList = mainRepo.getRepoList(isRefresh = true)

        assertThat(repoList).hasSize(1)
        assertThat(repoList).contains(mockData.first())
        verify(mainRepo, times(1)).getStarGazers("","")
        verify(mainRepo, times(1)).getLanguages("","")

        Unit
    }


}