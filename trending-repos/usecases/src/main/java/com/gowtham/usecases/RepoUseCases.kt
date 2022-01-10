package com.gowtham.usecases

import com.gowtham.lib.MainRepoImpl
import com.gowtham.lib.cache.TrendingRepoCache
import com.gowtham.lib.remote.ApiService
import com.squareup.sqldelight.db.SqlDriver

data class RepoUseCases(
    val getRepos: GetReposUseCase,
    val searchRepoUseCase: SearchRepoUseCase,
) {
    companion object Factory {
        fun build(sqlDriver: SqlDriver): RepoUseCases {
            val apiService = ApiService.build()
            val repoCache = TrendingRepoCache.build(sqlDriver)
            val mainRepo = MainRepoImpl(cache = repoCache, remote = apiService)
            return RepoUseCases(
                getRepos = GetReposUseCase(
                    mainRepo = mainRepo,
                ),
                searchRepoUseCase = SearchRepoUseCase(
                    mainRepo = mainRepo
                ),
            )
        }

        val schema: SqlDriver.Schema = TrendingRepoCache.schema

        val dbName: String = TrendingRepoCache.dbName
    }
}
