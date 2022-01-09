package com.gowtham.lib.cache

import com.gowtham.entities.Repository
import com.squareup.sqldelight.db.SqlDriver

interface TrendingRepoCache {

    suspend fun selectAll(): List<Repository>

    suspend fun searchByName(query: String): List<Repository>

    suspend fun insert(repos: List<Repository>)


    companion object Factory {
        fun build(sqlDriver: SqlDriver): TrendingRepoCacheImpl {
            return TrendingRepoCacheImpl(GithubDatabase(sqlDriver))
        }
        val schema: SqlDriver.Schema = GithubDatabase.Schema

        val dbName: String = "github.db"
    }



}


