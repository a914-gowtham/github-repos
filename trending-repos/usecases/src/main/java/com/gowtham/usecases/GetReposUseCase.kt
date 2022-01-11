package com.gowtham.usecases

import com.gowtham.lib.MainRepo

class GetReposUseCase(val mainRepo: MainRepo) {

    suspend fun execute() {
        mainRepo.getRepoList()
    }
}
