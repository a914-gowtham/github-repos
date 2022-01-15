package com.gowtham.usecases

import com.gowtham.core.ResultState
import com.gowtham.entities.Repository
import com.gowtham.lib.MainRepo

class SearchRepoUseCase(val mainRepo: MainRepo) {

    suspend fun execute(queryStr: String): ResultState<List<Repository>> {
        return try {
            val list = mainRepo.searchByName(queryStr)
            ResultState.Success(
                list
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ResultState.Failure(
                message = e.message ?: "Something went wrong!"
            )
        }
    }
}
