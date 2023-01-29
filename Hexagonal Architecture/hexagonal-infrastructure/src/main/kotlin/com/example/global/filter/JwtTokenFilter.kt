package com.example.global.filter

import com.example.global.security.token.JwtProperties
import com.example.global.security.token.JwtTokenParser
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtTokenFilter(
    private val jwtTokenParser: JwtTokenParser
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = resolvedToken(request)

        token?.run {
            SecurityContextHolder.getContext().authentication = jwtTokenParser.getAuthentication(token)
        }

        filterChain.doFilter(request, response)
    }

    private fun resolvedToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader("Authorization")

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7)
        }

        return null
    }
}