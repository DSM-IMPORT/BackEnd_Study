package com.example.global.security.token

import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenResolver(
    private val jwtProperties: JwtProperties
) {
    fun resolveToken(httpServletRequest: HttpServletRequest): String? {
        val bearerToken: String? = httpServletRequest.getHeader("Authorization")

        return parseToken(bearerToken)
    }

    fun parseToken(token: String?): String? {
        return if (token != null && token.startsWith("Bearer ")) {
            return token.replace("Bearer ", "")
        } else null
    }
}