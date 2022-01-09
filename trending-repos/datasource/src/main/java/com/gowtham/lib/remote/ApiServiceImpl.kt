package com.gowtham.lib.remote

import com.gowtham.lib.remote.model.RepoDto
import retrofit2.Response

class ApiServiceImpl : ApiService {
    override suspend fun getPokemonList(): Response<List<RepoDto>> {
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
}