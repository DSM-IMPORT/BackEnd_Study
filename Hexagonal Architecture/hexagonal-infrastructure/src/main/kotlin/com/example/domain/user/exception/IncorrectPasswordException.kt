package com.example.domain.user.exception

import com.example.domain.common.error.DomainErrorCode
import com.example.global.error.CustomException

class IncorrectPasswordException : CustomException(DomainErrorCode.INCORRECT_PASSWORD) {

    companion object {
        @JvmField
        val EXCEPTION = IncorrectPasswordException()
    }
}