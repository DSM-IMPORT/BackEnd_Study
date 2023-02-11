package com.example.domain.user.mapper

import com.example.domain.user.entity.UserJpaEntity
import com.example.domain.user.model.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val passwordEncoder: BCryptPasswordEncoder
) {

    fun toEntity(user: User): UserJpaEntity {

        return UserJpaEntity(
            user.id,
            user.accountId,
            passwordEncoder.encode(user.password),
            user.name,
            user.age
        )
    }

    fun toDomain(userJpaEntity: UserJpaEntity?): User? {
        return userJpaEntity?.let {
            User(
                id = it.id!!,
                accountId = it.accountId,
                name = it.name,
                age = it.age,
                password = it.password
            )
        }
    }
}