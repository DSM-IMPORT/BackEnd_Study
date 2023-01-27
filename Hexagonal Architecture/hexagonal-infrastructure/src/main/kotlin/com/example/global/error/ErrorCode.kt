package com.example.global.error

enum class ErrorCode(
    val status: Int,
    val message: String
): ErrorProperty {
    BAD_REQUEST(400, "Bad Request"),
    INTERNEL_SERVER_ERROR(500, "Internel Server Error");

    override fun status(): Int = status
    override fun message(): String = message
}