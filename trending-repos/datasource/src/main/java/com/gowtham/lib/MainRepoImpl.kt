package com.gowtham.lib

import com.gowtham.entities.Repository
import com.gowtham.lib.cache.GithubDatabase
import com.gowtham.lib.cache.TrendingRepoCache
import com.gowtham.lib.remote.ApiService
import com.gowtham.lib.remote.model.RepoDto
import retrofit2.Response

class MainRepoImpl(val cache: GithubDatabase,val remote: ApiService): MainRepo {
    override suspend fun getRepoList(): Response<List<RepoDto>> {
        TODO("Not yet implemented")
    }

    override suspend fun getStarGazers(ownerName: String, repoName: String): Response<List<Any>> {
        TODO("Not yet implemented")
    }

    override suspend fun getLanguages(
        ownerName: String,
        repoName: String
    ): Response<Map<String, Long>> {
        TODO("Not yet implemented")
    }

    override suspend fun selectAll(): List<Repository> {
        TODO("Not yet implemented")
    }

    override suspend fun searchByName(query: String): List<Repository> {
        TODO("Not yet implemented")
    }

    override suspend fun insert(repos: List<Repository>) {
        TODO("Not yet implemented")
    }


}