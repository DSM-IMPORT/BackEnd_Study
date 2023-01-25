package com.example.domain.user

import com.example.domain.user.mapper.UserMapper
import com.example.domain.user.repository.UserJpaRepository
import com.example.user.model.User
import com.example.domain.user.spi.UserPort
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userMapper: UserMapper
): UserPort {
    override fun saveUser(user: User) {
        userJpaRepository.save(userMapper.toEntity(user))
    }
}