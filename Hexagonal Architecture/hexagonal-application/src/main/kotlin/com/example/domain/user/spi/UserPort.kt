package com.example.domain.user.spi

import com.example.domain.user.dto.LoginRequest
import com.example.domain.user.model.User

interface UserPort {

    fun saveUser(user: User)

    fun verifyUser(loginRequest: LoginRequest): String

    fun findByAccountId(accountId: String): User?

}