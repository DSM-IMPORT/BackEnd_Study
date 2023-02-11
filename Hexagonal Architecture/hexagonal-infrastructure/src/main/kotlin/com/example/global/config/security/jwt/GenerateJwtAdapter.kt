package com.example.global.config.security.jwt

import com.example.domain.auth.dto.response.TokenResponse
import com.example.domain.auth.spi.JwtPort
import com.example.global.persistence.auth.entity.RefreshTokenEntity
import com.example.global.persistence.auth.repository.RefreshTokenRepository
import com.example.global.config.security.jwt.dotenv.JwtProperties
import com.example.global.exception.ExpiredTokenException
import io.jsonwebtoken.*
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
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

    @Transactional
    override fun reissue(rfToken: String): TokenResponse {

        val rf = refreshTokenRepository.findByToken(rfToken)
            ?: throw ExpiredTokenException.EXCEPTION

        val response = receiveToken(rf.token)

        refreshTokenRepository.delete(rf)

        return response
    }

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