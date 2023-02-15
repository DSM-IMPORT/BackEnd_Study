package com.example.domain.auth.spi

import com.example.domain.redis.model.RefreshToken

interface RedisPort {
    fun findByToken(token: String): RefreshToken?
}