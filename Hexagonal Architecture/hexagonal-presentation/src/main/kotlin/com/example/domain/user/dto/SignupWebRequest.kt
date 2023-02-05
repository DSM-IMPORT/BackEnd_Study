package com.example.domain.user.dto

import com.example.global.regex.PasswordRegexp
import javax.validation.constraints.Max
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class SignupWebRequest(
    @field:NotBlank
    @Size(min = 10, max = 20, message = "account_id는 최대 20자입니다.")
    val accountId: String,

    @field:NotBlank
    @field:Pattern(
        regexp = PasswordRegexp.REGEX,
        message = "정규식 지키셈"
    )
    val password: String,

    @field:NotBlank
    @field:Max(5)
    val name: String,

    @field:NotNull
    val age: Int
)
