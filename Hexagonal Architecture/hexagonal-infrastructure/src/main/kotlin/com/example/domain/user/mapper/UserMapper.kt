package com.example.domain.user.mapper

import com.example.domain.user.entity.UserJpaEntity
import com.example.domain.user.model.User
import org.springframework.stereotype.Component

@Component
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