package com.example.domain.user

import com.example.domain.user.exception.DuplicatedMemberException
import com.example.domain.user.mapper.UserMapper
import com.example.domain.user.repository.UserJpaRepository
import com.example.domain.user.model.User
import com.example.domain.user.spi.UserPort
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userMapper: UserMapper
): UserPort {

    override fun saveUser(user: User) {

        if(userJpaRepository.existsByAccountId(user.accountId)) {
            throw DuplicatedMemberException.EXCEPTION
        }

        userJpaRepository.save(userMapper.toEntity(user))
    }
}