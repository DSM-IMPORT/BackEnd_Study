package com.example.global.error

abstract class CustomException(
    val errorProperty: ErrorProperty
) : RuntimeException() {
    override fun fillInStackTrace() = this
}