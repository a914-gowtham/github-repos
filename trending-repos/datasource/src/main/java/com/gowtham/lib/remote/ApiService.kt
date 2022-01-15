package com.gowtham.lib.remote

import com.gowtham.constants.Constants.BASE_URL
import com.gowtham.lib.remote.model.Owner
import com.gowtham.lib.remote.model.RepoDto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
}

interface ApiService {

    @GET("repositories")
    suspend fun getRepoList(): Response<List<RepoDto>>

    @GET("repos/{ownerName}/{repoName}/stargazers")
    suspend fun getStarGazers(
        @Path("ownerName") ownerName: String,
        @Path("repoName") repoName: String,
    ): Response<List<Owner>>

    @GET("repos/{ownerName}/{repoName}/languages")
    suspend fun getLanguages(
        @Path("ownerName") ownerName: String,
        @Path("repoName") repoName: String,
    ): Response<Map<String, Long>>

    companion object Factory {
        fun build(): ApiService {
            val contentType = "application/json".toMediaType()

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(MyInterceptor())
                .build()
            return Retrofit.Builder()
                .client(httpClient)
                // kotlin serializer convertor
                .addConverterFactory(json.asConverterFactory(contentType))
                .baseUrl(BASE_URL)
                .build()
                .create(ApiService::class.java)
        }
    }
}

class MyInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {

        val request: Request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "token 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")
            .build()
        return chain.proceed(request)
    }

}
