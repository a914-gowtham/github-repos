package com.gowtham.lib.cache.model

import com.gowtham.entities.Repository
import com.gowtham.lib.cache.Github_Entity

fun Github_Entity.toRepo(): Repository {
    return Repository(
        id = id.toInt(),
        name = name,
        fullName = fullName,
        description = description,
        ownerName = ownerName,
        avatar = avatar,
        language = language,
        starsCount = starsCount.toInt()
    )
}
