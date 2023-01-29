package com.example.domain.user.spi

import com.example.domain.auth.dto.response.TokenResponse
import java.util.*

interface UserJwtPort {
    fun receiveToken(accountId: String): TokenResponse
}