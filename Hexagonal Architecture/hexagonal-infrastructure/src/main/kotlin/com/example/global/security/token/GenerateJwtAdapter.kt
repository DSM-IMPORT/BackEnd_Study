package com.example.global.security.token

import com.example.domain.auth.dto.response.TokenResponse
import com.example.domain.auth.spi.JwtPort
import com.example.global.persistence.auth.entity.RefreshTokenEntity
import com.example.global.persistence.auth.repository.RefreshTokenRepository
import com.example.global.security.SecurityProperties
import io.jsonwebtoken.*
import java.util.*

class GenerateJwtAdapter(
    private val securityProperties: SecurityProperties,
    private val refreshTokenRepository: RefreshTokenRepository
) : JwtPort{
    override fun receiveToken(accountId: String) = TokenResponse(
        accessToken = generateToken(accountId, securityProperties.accessExp),
        refreshToken = generateRefreshToken(accountId)
    )

    fun generateRefreshToken(accountId: String): String {
        val newRefreshToken: String = generateToken(accountId, securityProperties.refreshExp)
        refreshTokenRepository.save(
            RefreshTokenEntity(
                accountId = accountId,
                token = newRefreshToken
            )
        )
        return newRefreshToken
    }

    private fun generateToken(accountId: String, expiration: Long): String {
        return "Bearer " + Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
            .setSubject(accountId)
            .setHeaderParam("type", JwtProperties.ACCESS_KEY)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
            .compact()
    }
}