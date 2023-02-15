package com.example.global.persistence.auth

import com.example.domain.auth.spi.RedisPort
import com.example.domain.redis.model.RefreshToken
import com.example.global.persistence.auth.mapper.RefreshTokenMapper
import com.example.global.persistence.auth.repository.RefreshTokenRepository
import org.springframework.stereotype.Component

@Component
class RefreshTokenAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper
): RedisPort {

    override fun findByToken(token: String): RefreshToken? {
        return refreshTokenMapper.toDomain(
            refreshTokenRepository.findByToken(token)
        )
    }


}