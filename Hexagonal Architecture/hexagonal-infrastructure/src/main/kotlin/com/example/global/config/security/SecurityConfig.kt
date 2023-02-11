package com.example.global.config.security

import com.example.global.config.filter.FilterConfig
import com.example.global.config.security.jwt.JwtTokenParser
import com.example.global.config.security.jwt.JwtTokenResolver
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val objectMapper: ObjectMapper,
    private val jwtTokenParser: JwtTokenParser,
    private val jwtTokenResolver: JwtTokenResolver
) {

    @Bean
    @Throws(Exception::class)
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf().disable()
            .formLogin().disable()
            .cors().and()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeRequests()
            .antMatchers("*").permitAll()

            .and().apply(FilterConfig(objectMapper,jwtTokenParser, jwtTokenResolver))

            .and().build()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}