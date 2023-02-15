package com.example.global.error

import org.springframework.http.HttpStatus

enum class GlobalErrorCode(
    private val status: HttpStatus,
    private val message: String
): ErrorProperty {

    //400
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),

    //401
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid Token"),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "Expired Token"),

    //500
    INTERNAL_SERVER_GLOBAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error")
    ;

    override fun status(): Int = status.value()
    override fun message(): String = message
}