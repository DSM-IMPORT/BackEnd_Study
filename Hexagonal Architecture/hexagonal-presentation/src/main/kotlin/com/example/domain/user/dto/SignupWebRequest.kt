package com.example.domain.user.dto

import com.example.global.regex.PasswordRegexp
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class SignupWebRequest(
    @field:NotBlank
    @field:Size(min = 10, max = 20, message = "account_id는 최대 20자입니다.")
    val accountId: String,

    @field:NotBlank
    @field:Pattern(
        regexp = PasswordRegexp.REGEX,
        message = "8자 ~ 16자, 하나 이상의 문자, 하나의 이상의 숫자 및 하나의 이상의 특수 문자"
    )
    val password: String,

    @field:NotBlank
    @field:Size(min = 2, max = 5, message = "이름은 2 ~ 5 글자 입니다")
    val name: String,

    @field:NotNull
    val age: Int
)
