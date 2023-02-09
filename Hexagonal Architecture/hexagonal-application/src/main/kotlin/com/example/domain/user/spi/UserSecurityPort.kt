package com.example.domain.user.spi

interface UserSecurityPort {
    fun getCurrentUserId(): String
}