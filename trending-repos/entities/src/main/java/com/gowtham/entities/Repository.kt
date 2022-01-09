package com.gowtham.entities

data class Repository(
    val description: String,
    val full_name: String,
    val id: Int,
    val language: String?,
    val starsCount: Int?,
    val name: String,
    val owner: Owner,
)