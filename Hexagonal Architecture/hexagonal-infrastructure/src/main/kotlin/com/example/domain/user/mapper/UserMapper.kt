package com.example.domain.user.mapper

import com.example.domain.user.entity.UserJpaEntity
import com.example.domain.user.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toEntity(user: User): UserJpaEntity {

        return UserJpaEntity(
            user.id,
            user.accountId,
            user.password,
            user.name,
            user.age
        )
    }
}