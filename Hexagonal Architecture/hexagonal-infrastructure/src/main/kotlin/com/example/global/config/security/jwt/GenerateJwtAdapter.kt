package com.example.global.config.security.jwt

import com.example.domain.auth.dto.response.TokenResponse
import com.example.domain.auth.spi.JwtPort
import com.example.global.config.security.jwt.property.JwtProperties
import com.example.global.persistence.auth.entity.RefreshTokenEntity
import com.example.global.persistence.auth.repository.RefreshTokenRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateJwtAdapter(
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
) : JwtPort{


    override fun receiveToken(accountId: String) = TokenResponse(
        generateToken(accountId),
        generateRefreshToken(accountId)
    )


    private fun generateRefreshToken(accountId: String): String {

        val newRefreshToken = Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setHeaderParam("type", jwtProperties.refreshTyp)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.refreshExp * 1000))
            .compact()

        refreshTokenRepository.save(
            RefreshTokenEntity(
                accountId,
                newRefreshToken
            )
        )
        return newRefreshToken
    }

    private fun generateToken(accountId: String): String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setSubject(accountId)
            .setHeaderParam("type", jwtProperties.accessTyp)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()
    }
}