package com.example.domain.user.usecase

import com.example.domain.user.dto.request.SignupRequest
import com.example.domain.user.model.User
import com.example.domain.user.spi.UserPort
import com.example.global.annotation.UseCase

@UseCase
class SignupUseCase(
    private val userPort: UserPort
) {

    fun execute(signupRequest: SignupRequest) {
        val user = User(
            null,
            signupRequest.accountId,
            signupRequest.password,
            signupRequest.name,
            signupRequest.age
        )
        userPort.saveUser(user)
    }

}