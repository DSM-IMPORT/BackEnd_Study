package com.example.global.filter

import com.example.global.security.token.JwtTokenParser
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val objectMapper: ObjectMapper,
    private val jwtTokenParser: JwtTokenParser
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtTokenFilter(jwtTokenParser), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(ExceptionFilter(objectMapper), JwtTokenFilter::class.java)
    }
}