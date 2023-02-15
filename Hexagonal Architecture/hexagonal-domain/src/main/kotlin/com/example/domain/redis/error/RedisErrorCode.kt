package com.example.domain.user.error

import com.example.global.error.ErrorProperty

enum class RedisErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {

    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found")
    ;

    override fun status(): Int = status
    override fun message(): String = message
}