package com.example.user.model


data class User(
    val id: Long?,
    val accountId: String,
    val password: String,
    val name: String,
    val age: Int
)
