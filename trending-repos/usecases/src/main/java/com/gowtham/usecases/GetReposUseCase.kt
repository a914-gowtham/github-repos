package com.gowtham.usecases

import com.gowtham.lib.MainRepo

class GetReposUseCase(val mainRepo: MainRepo) {

    suspend fun execute(refresh: Boolean= false) {
        mainRepo.getRepoList(isRefresh= refresh)
    }
}
