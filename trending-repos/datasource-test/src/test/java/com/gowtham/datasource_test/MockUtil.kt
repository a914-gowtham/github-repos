package com.gowtham.datasource_test

import com.gowtham.entities.Repository
import com.gowtham.lib.remote.model.Owner
import com.gowtham.lib.remote.model.RepoDto

object MockUtil {


    fun mockRepo() = Repository(
        id = 2,
        name = "okhttp",
        fullName = "square/okhttp",
        ownerName = "square",
        description = "",
        avatar = "",
        language = "",
        starsCount = 26
    )

    fun mockRepoList() = listOf(mockRepo())

    fun mockApiRepo() = RepoDto(
        id = 2,
        name = "okhttp",
        fullName = "square/okhttp",
        owner = Owner(2,"",""),
        description = "",
        languagesUrl = "",
        starGazersUrl = ""
    )

    fun mockApiRepoList() = listOf(mockApiRepo())
}