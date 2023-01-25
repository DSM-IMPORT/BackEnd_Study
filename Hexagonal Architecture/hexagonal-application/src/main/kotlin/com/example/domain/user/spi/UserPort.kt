package com.example.domain.user.spi

import com.example.domain.user.model.User

interface UserPort {
    fun saveUser(user: User)
}