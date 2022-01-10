package com.gowtham.lib

import com.gowtham.entities.Repository
import com.gowtham.lib.remote.model.RepoDto
import retrofit2.Response

interface MainRepo {

    suspend fun getRepoList(): Response<List<RepoDto>>

    suspend fun getStarGazers(
        ownerName: String, repoName: String,
    ): Response<List<Any>>

    suspend fun getLanguages(
        ownerName: String,
        repoName: String,
    ): Response<Map<String, Long>>

    suspend fun selectAll(): List<Repository>

    suspend fun searchByName(query: String): List<Repository>

    suspend fun insert(repos: List<Repository>)

}