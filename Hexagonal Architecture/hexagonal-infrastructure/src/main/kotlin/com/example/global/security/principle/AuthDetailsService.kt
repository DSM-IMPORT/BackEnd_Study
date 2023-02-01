package com.example.global.security.principle

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService : UserDetailsService {
    override fun loadUserByUsername(accountId: String): UserDetails {
        TODO("Not yet implemented")
    }
}