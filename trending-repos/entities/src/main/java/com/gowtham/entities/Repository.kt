package com.gowtham.entities

data class Repository(
    val id: Int,
    val name: String,
    val fullName: String,
    val description: String,
    val ownerName: String,
    val avatar: String,
    var language: String,
    var starsCount: Int,
)
