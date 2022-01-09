package com.gowtham.lib.remote

import com.gowtham.lib.cache.GithubDatabase
import com.gowtham.lib.cache.TrendingRepoCacheImpl
import com.gowtham.lib.remote.model.RepoDto
import com.squareup.sqldelight.db.SqlDriver
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("repositories")
    suspend fun getPokemonList(): Response<List<RepoDto>>

    @GET("repos/{ownerName}/{repoName}/stargazers")
    suspend fun getStarGazers(
        @Path("ownerName") ownerName: String,
        @Path("repoName") repoName: String,
    ): Response<List<Any>>

    @GET("repos/{ownerName}/{repoName}/languages")
    suspend fun getLanguages(
        @Path("ownerName") ownerName: String,
        @Path("repoName") repoName: String,
    ): Response<Map<String, Long>>

    companion object Factory {
        fun build(sqlDriver: SqlDriver): TrendingRepoCacheImpl {
            return TrendingRepoCacheImpl(GithubDatabase(sqlDriver))
        }
        val schema: SqlDriver.Schema = GithubDatabase.Schema

        val dbName: String = "github.db"
    }
}