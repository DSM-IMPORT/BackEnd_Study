package com.example.domain.user.usecase

import com.example.domain.auth.dto.response.TokenResponse
import com.example.domain.user.dto.request.LoginRequest
import com.example.domain.user.spi.UserJwtPort
import com.example.domain.user.spi.UserPort
import com.example.global.annotation.UseCase

@UseCase
class LoginUseCase(
    private val userPort: UserPort,
    private val userJwtPort: UserJwtPort
) {

    fun execute(loginRequest: LoginRequest): TokenResponse {
        return userJwtPort.receiveToken(
            userPort.verifyUser(loginRequest)
        )
    }

}