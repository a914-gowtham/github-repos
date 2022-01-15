package com.gowtham.lib

import com.gowtham.entities.Repository

interface MainRepo {

    suspend fun getRepoList(isRefresh: Boolean): List<Repository>

    suspend fun getStarGazers(
        ownerName: String,
        repoName: String,
    ): Int

    suspend fun getLanguages(
        ownerName: String,
        repoName: String,
    ): String

    suspend fun selectAll(): List<Repository>

    suspend fun searchByName(query: String): List<Repository>

    suspend fun insert(repos: Repository)
}
