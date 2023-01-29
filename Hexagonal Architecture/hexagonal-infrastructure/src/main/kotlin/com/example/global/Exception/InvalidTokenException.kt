package com.example.global.Exception

import com.example.global.error.CustomException
import com.example.global.error.ErrorCode

class InvalidTokenException : CustomException(ErrorCode.INVALID_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = InvalidTokenException()
    }
}