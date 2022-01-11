package com.gowtham.lib.cache.model

import com.gowtham.entities.Repository
import com.gowtham.lib.cache.Github_Entity
import com.gowtham.lib.remote.model.Owner
import com.gowtham.lib.remote.model.RepoDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

fun Github_Entity.toRepo(): Repository {
   return Repository(
       id = id.toInt(),
       name = name,
       fullName = fullName,
       description = description,
       ownerName = ownerName,
       language = language,
       starsCount = starsCount.toInt()
   )
}
