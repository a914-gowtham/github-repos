package com.gowtham.usecases

import com.gowtham.lib.cache.TrendingRepoCache
import com.squareup.sqldelight.db.SqlDriver

data class RepoUseCases(
    val getRepos: GetReposUseCase,
    val searchRepoUseCase: SearchRepoUseCase,
) {
    companion object Factory {
        fun build(sqlDriver: SqlDriver): RepoUseCases {
//            val service = HeroService.build()
            val repoCache = TrendingRepoCache.build(sqlDriver)
            return RepoUseCases(
                getRepos = GetReposUseCase(
                    cache = repoCache,
//                    service = service,
                ),
                searchRepoUseCase = SearchRepoUseCase(cache = repoCache),
            )
        }

        val schema: SqlDriver.Schema = TrendingRepoCache.schema

        val dbName: String = TrendingRepoCache.dbName
    }
}
