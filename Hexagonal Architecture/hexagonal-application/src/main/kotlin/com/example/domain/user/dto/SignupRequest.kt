package com.example.domain.user.dto

data class SignupRequest(
    val accountId: String,
    val password: String,
    val name: String,
    val age: Int
)