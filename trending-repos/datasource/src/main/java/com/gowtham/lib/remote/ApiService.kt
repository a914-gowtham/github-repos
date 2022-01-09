package com.gowtham.lib.remote
import com.gowtham.lib.remote.model.RepoDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("repositories")
    suspend fun getPokemonList(): Response<List<RepoDto>>
}