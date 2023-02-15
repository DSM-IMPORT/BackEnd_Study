package com.example.domain.redis.model

import com.example.global.annotation.Aggregate

@Aggregate
data class RefreshToken (

    val accountId: String,

    val token: String
)