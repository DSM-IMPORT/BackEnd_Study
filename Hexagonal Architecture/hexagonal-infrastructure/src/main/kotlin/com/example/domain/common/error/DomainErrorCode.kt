package com.example.domain.common.error

import com.example.global.error.ErrorProperty

enum class DomainErrorCode(
    private val status: Int,
    private val message: String
): ErrorProperty {

    DUPLICATED_MEMBER(400, "")
    ;

    override fun status(): Int = status
    override fun message(): String = message
}