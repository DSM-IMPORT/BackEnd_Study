package com.example.global.security

import com.example.global.filter.FilterConfig
import com.example.global.security.token.JwtTokenParser
import com.example.global.security.token.JwtTokenResolver
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val objectMapper: ObjectMapper,
    private val jwtTokenParser: JwtTokenParser,
    private val jwtTokenResolver: JwtTokenResolver
) {

    @Bean
    @Throws(Exception::class)
    protected fun filterchain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .formLogin().disable()
            .cors().and()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeRequests()
            .antMatchers("*").permitAll()

            .and().apply(FilterConfig(objectMapper,jwtTokenParser, jwtTokenResolver))

        return http.build()
    }

    @Bean
    fun passwordEncorder(): PasswordEncoder = BCryptPasswordEncoder()
}