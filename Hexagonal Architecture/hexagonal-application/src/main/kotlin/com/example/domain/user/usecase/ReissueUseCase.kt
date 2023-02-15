package com.example.domain.user.usecase

import com.example.domain.auth.dto.response.TokenResponse
import com.example.domain.auth.exception.RefreshTokenNotFoundException
import com.example.domain.auth.spi.RedisPort
import com.example.domain.user.dto.request.ReissueRequest
import com.example.domain.user.spi.UserJwtPort
import com.example.global.annotation.UseCase

@UseCase
class ReissueUseCase(
    private val redisPort: RedisPort,
    private val userJwtPort: UserJwtPort
) {

    fun reissue(request: ReissueRequest): TokenResponse {
        val rf = redisPort.findByToken(request.refreshToken)
            ?: throw RefreshTokenNotFoundException

        return userJwtPort.receiveToken(rf.accountId)
    }
}