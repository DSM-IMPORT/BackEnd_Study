package com.example.global.exception

import com.example.global.error.CustomException
import com.example.global.error.GlobalErrorCode

class ExpiredTokenException : CustomException(GlobalErrorCode.EXPIRED_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = ExpiredTokenException()
    }
}