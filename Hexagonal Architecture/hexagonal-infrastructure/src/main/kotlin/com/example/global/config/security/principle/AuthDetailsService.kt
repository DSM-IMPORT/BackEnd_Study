package com.example.global.config.security.principle

import com.example.domain.user.repository.UserJpaRepository
import com.example.global.exception.InternalServerErrorException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val userJpaRepository: UserJpaRepository
) : UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        return AuthDetails(userJpaRepository.findByAccountId(accountId)
            ?: throw InternalServerErrorException.EXCEPTION)
    }
}