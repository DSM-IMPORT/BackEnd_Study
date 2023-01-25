package com.example.domain.user.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class SignupWebRequest(
    @field:NotNull
    @Size(max = 20, message = "account_id는 최대 20자입니다.")
    val accountId: String,
    val password: String,
    val name: String,
    val age: Int
)
