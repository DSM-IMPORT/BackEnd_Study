package com.example.domain.user.dto.request

data class LoginRequest(
    val accountId: String,
    val password: String
)