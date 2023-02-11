package com.example.domain.user.exception

import com.example.domain.common.error.DomainErrorCode
import com.example.global.error.CustomException

class UserNotFoundException : CustomException(DomainErrorCode.USER_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }
}