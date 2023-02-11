package com.example.domain.user.usecase

import com.example.domain.user.dto.request.ReissueRequest
import com.example.domain.user.spi.UserJwtPort
import com.example.global.annotation.UseCase

@UseCase
class ReissueUseCase(
    private val userJwtPort: UserJwtPort
) {

    fun reissue(request: ReissueRequest) = userJwtPort.reissue(request.refreshToken)
}