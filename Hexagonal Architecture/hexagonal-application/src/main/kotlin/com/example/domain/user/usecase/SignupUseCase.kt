package com.example.domain.user.usecase

import com.example.domain.user.dto.SignupRequest
import com.example.user.model.User
import com.example.domain.user.spi.UserPort
import com.example.global.annotation.UseCase

@UseCase
class SignupUseCase(
    private val userPort: UserPort
) {

    fun execute(signupRequest: SignupRequest) {
        val user = User(
            id = null,
            accountId = signupRequest.accountId,
            password = signupRequest.password+"*%@#$%@",
            name = signupRequest.name,
            age = signupRequest.age
        )
        userPort.saveUser(user)
    }

}