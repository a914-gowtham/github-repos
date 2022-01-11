package com.gowtham.lib

import com.gowtham.entities.Repository
import com.gowtham.lib.cache.GithubDatabase
import com.gowtham.lib.cache.GithubQueries
import com.gowtham.lib.cache.model.toRepo
import com.gowtham.lib.remote.ApiService
import com.gowtham.lib.remote.model.toRepo

class MainRepoImpl(val cache: GithubDatabase, val remote: ApiService) : MainRepo {

    private val queries: GithubQueries = cache.githubQueries

    override suspend fun getRepoList(): List<Repository> {
        val cacheRepoList = queries.selectAll().executeAsList().map { it.toRepo() }

        try {
            print("Hello ${cacheRepoList.size}")
            val response = remote.getRepoList()
            val remoteList = response.body()!!
            println("${remoteList.first()}")
            for (repo in remoteList)
                insert(repo.toRepo(0, ""))
            return emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
//            throw Exception(e)
        }
        /* return if (cacheRepoList.isEmpty()) {
             try {
                 val response = remote.getRepoList()
                 val remoteList = response.body()!!.map {
                     it.toRepo(getStarGazers(it.owner.login,it.name), "") }
                 for (repo in remoteList)
                     insert(repo)
                 return remoteList
             } catch (e: Exception) {
                 e.printStackTrace()
                 throw Exception(e)
             }

         } else
             cacheRepoList*/

        return emptyList()
    }

    override suspend fun getStarGazers(ownerName: String, repoName: String): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getLanguages(
        ownerName: String,
        repoName: String
    ): String {
        TODO("Not yet implemented")
    }

    override suspend fun selectAll(): List<Repository> {
        TODO("Not yet implemented")
    }

    override suspend fun searchByName(query: String): List<Repository> {
        TODO("Not yet implemented")
    }

    override suspend fun insert(repo: Repository) {
        return repo.run {
            queries.insertRepository(
                id = id.toLong(),
                name = name,
                fullName = fullName,
                description = description,
                ownerName = ownerName,
                language = language,
                starsCount = starsCount.toLong()
            )
        }
    }
}
