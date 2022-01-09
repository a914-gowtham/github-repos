package com.gowtham.usecases

import com.gowtham.lib.cache.TrendingRepoCache

class SearchRepoUseCase(private val cache: TrendingRepoCache) {


    suspend fun execute(query: String){

    }
}