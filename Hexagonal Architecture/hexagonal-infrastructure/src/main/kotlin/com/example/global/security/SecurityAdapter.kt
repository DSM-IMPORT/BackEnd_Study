package com.example.global.security

import com.example.domain.user.spi.UserSecurityPort
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class SecurityAdapter: UserSecurityPort {

    override fun getCurrentUserId(): String {
        return SecurityContextHolder.getContext().authentication.name
    }
}