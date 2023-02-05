package com.example.global.error

enum class GlobalErrorCode(
    private val status: Int,
    private val message: String
): ErrorProperty {

    BAD_REQUEST(400, "Bad Request"),
    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),
    INTERNAL_SERVER_GLOBAL_ERROR(500, "Internal Server Error")
    ;

    override fun status(): Int = status
    override fun message(): String = message
}