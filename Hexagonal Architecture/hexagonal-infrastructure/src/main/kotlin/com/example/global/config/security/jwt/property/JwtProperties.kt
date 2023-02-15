package com.example.global.config.security.jwt.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.*

@ConfigurationProperties(prefix = "spring.jwt")
@ConstructorBinding
class JwtProperties(
    accessExp: Long,
    refreshExp: Long,
    secret: String,
    accessTyp: String,
    refreshTyp: String
) {
    val accessExp = accessExp * 1000
    val refreshExp = refreshExp * 1000
    val secretKey: String = Base64.getEncoder().encodeToString(secret.toByteArray())
    val accessTyp = accessTyp
    val refreshTyp = refreshTyp
}