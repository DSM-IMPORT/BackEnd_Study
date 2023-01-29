package com.example.global.filter

import com.example.global.security.token.JwtTokenParser
import com.example.global.security.token.JwtTokenResolver
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtTokenFilter(
    private val jwtTokenResolver: JwtTokenResolver,
    private val jwtTokenParser: JwtTokenParser
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = jwtTokenResolver.resolveToken(request)

        token?.run {
            SecurityContextHolder.getContext().authentication = jwtTokenParser.getAuthentication(token)
        }

        filterChain.doFilter(request, response)
    }
}