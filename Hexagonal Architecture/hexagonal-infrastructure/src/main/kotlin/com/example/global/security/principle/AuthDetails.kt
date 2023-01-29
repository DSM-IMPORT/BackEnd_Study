package com.example.global.security.principle

import com.example.domain.user.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: User
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf()

    override fun getPassword(): String? = null

    override fun getUsername(): String = user.accountId

    override fun isAccountNonExpired(): Boolean = false

    override fun isAccountNonLocked(): Boolean = false

    override fun isCredentialsNonExpired(): Boolean = false

    override fun isEnabled(): Boolean = false
}