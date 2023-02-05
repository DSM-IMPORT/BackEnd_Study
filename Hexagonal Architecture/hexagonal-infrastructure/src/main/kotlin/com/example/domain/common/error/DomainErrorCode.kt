package com.example.domain.common.error

import com.example.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class DomainErrorCode(
    private val status: HttpStatus,
    private val message: String
): ErrorProperty {

    //400
    DUPLICATED_MEMBER(HttpStatus.BAD_REQUEST, ""),
    INCORRECT_PASSWORD(HttpStatus.BAD_REQUEST, ""),

    //404
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "")
    ;

    override fun status(): Int = status.value()
    override fun message(): String = message
}