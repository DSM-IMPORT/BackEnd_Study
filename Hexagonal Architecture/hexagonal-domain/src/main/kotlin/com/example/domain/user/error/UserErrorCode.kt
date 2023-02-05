package com.example.domain.user.error

import com.example.global.error.ErrorProperty

enum class UserErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {

    USER_NOT_FOUND(404, "User Not Found")
    ;

    override fun status(): Int = status
    override fun message(): String = message
}