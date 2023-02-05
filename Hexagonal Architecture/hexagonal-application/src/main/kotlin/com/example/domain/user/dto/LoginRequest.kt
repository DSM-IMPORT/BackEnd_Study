package com.example.domain.user.dto

data class LoginRequest(
    val accountId: String,
    val password: String
)