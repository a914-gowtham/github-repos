package com.gowtham.lib.cache

import com.squareup.sqldelight.db.SqlDriver

class TrendingRepoCache {

    companion object Factory {
        fun build(sqlDriver: SqlDriver): GithubDatabase {
            return GithubDatabase(sqlDriver)
        }
        val schema: SqlDriver.Schema = GithubDatabase.Schema

        val dbName: String = "github.db"
    }
}
