package com.example.global.Exception

import com.example.global.error.CustomException
import com.example.global.error.ErrorCode

class InternalServerErrorException(): CustomException(ErrorCode.INTERNEL_SERVER_ERROR) {
    companion object {
        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }
}