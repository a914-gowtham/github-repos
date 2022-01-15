package com.gowtham.usecases

import com.gowtham.core.ResultState
import com.gowtham.entities.Repository
import com.gowtham.lib.MainRepo
import java.net.UnknownHostException

class GetReposUseCase(val mainRepo: MainRepo) {

    suspend fun execute(refresh: Boolean = false): ResultState<List<Repository>> {
        return try {
            val list = mainRepo.getRepoList(isRefresh = refresh)
            ResultState.Success(
                list
            )
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is UnknownHostException)
                return ResultState.Failure(
                    message = "No network connection"
                )
            ResultState.Failure(
                message = e.message ?: "Something went wrong!"
            )
        }
    }
}
