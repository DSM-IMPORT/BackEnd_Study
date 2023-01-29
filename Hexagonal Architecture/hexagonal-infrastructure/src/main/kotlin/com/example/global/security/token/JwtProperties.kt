package com.example.global.security.token

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

object JwtProperties {
    const val ACCESS_KEY = "access"
    const val REFRESH_KEY = "refresh"
}