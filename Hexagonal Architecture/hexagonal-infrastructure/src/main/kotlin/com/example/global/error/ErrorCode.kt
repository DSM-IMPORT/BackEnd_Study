package com.example.global.error

enum class ErrorCode(
    val status: Int,
    val message: String
): ErrorProperty {
    BAD_REQUEST(400, "Bad Request"),
    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),
    INTERNEL_SERVER_ERROR(500, "Internel Server Error");

    override fun status(): Int = status
    override fun message(): String = message
}