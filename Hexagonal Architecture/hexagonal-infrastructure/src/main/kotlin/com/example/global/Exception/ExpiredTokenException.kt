package com.example.global.Exception

import com.example.global.error.CustomException
import com.example.global.error.ErrorCode

class ExpiredTokenException : CustomException(ErrorCode.EXPIRED_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = ExpiredTokenException()
    }
}