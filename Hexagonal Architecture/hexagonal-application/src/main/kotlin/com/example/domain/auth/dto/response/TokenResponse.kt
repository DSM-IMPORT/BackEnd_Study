package com.example.domain.auth.dto.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)