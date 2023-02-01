package com.example.global.persistence.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import javax.persistence.Column

@RedisHash(value = "RefreshToken", timeToLive = 60 * 60 * 2)
data class RefreshTokenEntity(
    @Id
    val accountId: String,

    @Indexed
    @Column(nullable = false)
    val token: String
)