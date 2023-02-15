package com.example.global.persistence.auth.mapper

import com.example.domain.redis.model.RefreshToken
import com.example.global.persistence.auth.entity.RefreshTokenEntity
import org.springframework.stereotype.Component

@Component
class RefreshTokenMapper{

    fun toEntity(refreshToken: RefreshToken) = RefreshTokenEntity(
        refreshToken.accountId,
        refreshToken.token
    )

    fun toDomain(refreshTokenEntity: RefreshTokenEntity?): RefreshToken?{

        return refreshTokenEntity?.let {
            RefreshToken(
                refreshTokenEntity.accountId,
                refreshTokenEntity.token
            )
        }
    }
}