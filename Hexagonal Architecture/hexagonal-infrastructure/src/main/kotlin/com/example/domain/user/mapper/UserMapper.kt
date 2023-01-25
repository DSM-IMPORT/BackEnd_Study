package com.example.domain.user.mapper

import com.example.domain.user.entity.UserJpaEntity
import com.example.user.model.User

class UserMapper {
    fun toEntity(user: User): UserJpaEntity {
        return UserJpaEntity(
            id = user.id,
            accountId = user.accountId,
            password = user.password,
            name = user.name,
            age = user.age
        )
    }
}