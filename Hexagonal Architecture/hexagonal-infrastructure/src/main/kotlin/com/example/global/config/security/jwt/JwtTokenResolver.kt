package com.example.global.config.security.jwt

import com.example.global.config.security.jwt.dotenv.JwtProperties
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
        httpServletRequest.getHeader("Authorization"),
        httpServletRequest.getParameter("type")
    )

    fun parseToken(token: String?, type: String?): String? {

        return if (token != null && Pattern.matches(REGEX_BEARER_TOKEN, token) && type == jwtProperties.accessTyp) {
            token.substring(7)
        }
        else {
            null
        }
    }
}