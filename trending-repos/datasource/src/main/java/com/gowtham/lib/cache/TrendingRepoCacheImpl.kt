package com.gowtham.lib.cache

import com.gowtham.entities.Repository

class TrendingRepoCacheImpl(private val githubDatabase: GithubDatabase,
): TrendingRepoCache {


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