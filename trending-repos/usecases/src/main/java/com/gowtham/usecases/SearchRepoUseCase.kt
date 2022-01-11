package com.gowtham.usecases

import com.gowtham.lib.MainRepo

class SearchRepoUseCase(val mainRepo: MainRepo) {

    suspend fun execute(query: String) {
    }
}
