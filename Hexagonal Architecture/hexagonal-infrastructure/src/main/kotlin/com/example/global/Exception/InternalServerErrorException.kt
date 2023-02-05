package com.example.global.exception

import com.example.global.error.CustomException
import com.example.global.error.GlobalErrorCode

class InternalServerErrorException(): CustomException(GlobalErrorCode.INTERNAL_SERVER_GLOBAL_ERROR) {
    companion object {
        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }
}