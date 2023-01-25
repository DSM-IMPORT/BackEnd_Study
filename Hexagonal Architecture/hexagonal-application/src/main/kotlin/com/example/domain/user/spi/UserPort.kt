package com.example.domain.user.spi

import com.example.user.model.User
import org.springframework.stereotype.Component

interface UserPort {
    fun saveUser(user: User)
}