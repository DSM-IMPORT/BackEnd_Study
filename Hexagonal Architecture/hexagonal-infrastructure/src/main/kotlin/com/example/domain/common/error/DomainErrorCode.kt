package com.example.domain.common.error

import com.example.global.error.ErrorProperty

enum class DomainErrorCode(
    private val status: Int,
    private val message: String
): ErrorProperty {

    //400
    DUPLICATED_MEMBER(400, ""),
    INCORRECT_PASSWORD(400, ""),

    //404
    USER_NOT_FOUND(404, "")
    ;

    override fun status(): Int = status
    override fun message(): String = message
}