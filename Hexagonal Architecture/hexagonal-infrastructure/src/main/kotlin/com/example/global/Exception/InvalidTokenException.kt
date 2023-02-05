package com.example.global.exception

import com.example.global.error.CustomException
import com.example.global.error.GlobalErrorCode

class InvalidTokenException : CustomException(GlobalErrorCode.INVALID_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = InvalidTokenException()
    }
}