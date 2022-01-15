package com.gowtham.lib

import com.gowtham.entities.Repository
import com.gowtham.lib.cache.GithubDatabase
import com.gowtham.lib.cache.GithubQueries
import com.gowtham.lib.cache.model.toRepo
import com.gowtham.lib.remote.ApiService
import com.gowtham.lib.remote.model.RepoDto
import com.gowtham.lib.remote.model.toRepo
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow
import kotlin.system.measureTimeMillis

class MainRepoImpl(val cache: GithubDatabase, val remote: ApiService) : MainRepo {

    private val queries: GithubQueries = cache.githubQueries

    override suspend fun getRepoList(isRefresh: Boolean): List<Repository> {
        val cacheRepoList = queries.selectAll().executeAsList().map { it.toRepo() }

         return if (cacheRepoList.isEmpty() || isRefresh) {
             try {
                 val response = remote.getRepoList()
                 return fetchStarAndLanguage(response.body()!!)
             } catch (e: Exception) {
                 e.printStackTrace()
                 throw e
             }
         } else
             cacheRepoList
    }


    private suspend fun fetchStarAndLanguage(list: List<RepoDto>): List<Repository> {
        val resultList= mutableListOf<Repository>()
        val errorHandler = CoroutineExceptionHandler { _, throwable ->
            println("Error thrown somewhere within parent or child: $throwable")
        }
        val parentJob = CoroutineScope(Dispatchers.IO).launch(errorHandler) {
            supervisorScope {
                for (repo in list) {
                    launch {
                        val starGazers =
                            getStarGazers(
                                ownerName = repo.owner.login,
                                repoName = repo.name
                            )
                        val language =
                            getLanguages(
                                ownerName = repo.owner.login,
                                repoName = repo.name
                            )
                        val githubRepo = repo.toRepo(starCount = starGazers, language = language)
                        resultList.add(githubRepo)
                        insert(githubRepo)
                    }
                }
            }
        }
        parentJob.join()
        return resultList
    }

    override suspend fun getStarGazers(ownerName: String, repoName: String): Int {
        try {
            val response = remote.getStarGazers(
                ownerName = ownerName,
                repoName = repoName
            )
            if (response.isSuccessful && response.body() != null)
                return response.body()!!.size
            return -1
        } catch (e: Exception) {
            e.printStackTrace()
            return -1
        }
    }

    override suspend fun getLanguages(
        ownerName: String,
        repoName: String
    ): String {
        try {
            val response = remote.getLanguages(
                ownerName = ownerName,
                repoName = repoName
            )
            if (response.isSuccessful && response.body() != null) {
                val map = response.body()!!
                return map.keys.first()
            }
            return "N/A"
        } catch (e: Exception) {
            e.printStackTrace()
            return "N/A"
        }
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
