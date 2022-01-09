package com.gowtham.lib.remote.model

import com.gowtham.entities.Repository
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepoDto(
    val id: Int,
    val name: String,
    @SerialName("full_name")
    val fullName: String,
    val description: String,
    val ownerName: String,
    @SerialName("languages_url")
    val languagesUrl: String,
    @SerialName("stargazers_url")
    val starGazersUrl: String,
    val owner: Owner
)

@Serializable
data class Owner(
    val id: Int,
    val login: String,
)

fun RepoDto.toRepo(starCount: Int, language: String): Repository {
   return Repository(
       id = id,
       name = name,
       fullName = fullName,
       description = description,
       ownerName = owner.login,
       language = language,
       starsCount = starCount
   )
}
