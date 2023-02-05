package com.example.domain.user.exception

import com.example.domain.common.error.DomainErrorCode
import com.example.global.error.CustomException

class DuplicatedMemberException : CustomException(DomainErrorCode.DUPLICATED_MEMBER) {
    companion object {
        @JvmField
        val EXCEPTION = DuplicatedMemberException()
    }
}