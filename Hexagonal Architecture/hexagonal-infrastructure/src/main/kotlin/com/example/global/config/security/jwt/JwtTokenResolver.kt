package com.example.global.config.security.jwt

import com.example.global.config.security.jwt.dotenv.JwtProperties
import io.jsonwebtoken.Jwt
import org.springframework.stereotype.Component
import java.util.regex.Pattern
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenResolver(
    private val jwtProperties: JwtProperties
) {

    companion object{
        private const val REGEX_BEARER_TOKEN = "Bearer [(a-zA-Z0-9-._~+/=*)]{30,600}"
    }

    fun resolveToken(httpServletRequest: HttpServletRequest) = parseToken(
        httpServletRequest.getHeader("Authorization")
    )

    fun parseToken(token: String?): String? {

        return if (token != null && Pattern.matches(REGEX_BEARER_TOKEN, token)) {
            token.substring(7)
        }
        else {
            null
        }
    }
}