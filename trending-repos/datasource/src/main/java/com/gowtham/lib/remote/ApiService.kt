package com.gowtham.lib.remote

import com.gowtham.lib.remote.model.RepoDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("repositories")
    suspend fun getRepoList(): Response<List<RepoDto>>

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
        fun build(): ApiService {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient= OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
          return Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BASE_URL)
                .build()
                .create(ApiService::class.java)
        }
    }
}