package com.example.domain.user.spi

import com.example.domain.auth.dto.response.TokenResponse

interface UserJwtPort {

    fun receiveToken(accountId: String): TokenResponse
}