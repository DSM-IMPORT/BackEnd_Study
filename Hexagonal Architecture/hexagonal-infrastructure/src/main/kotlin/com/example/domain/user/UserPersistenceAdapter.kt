package com.example.domain.user

import com.example.domain.user.dto.LoginRequest
import com.example.domain.user.exception.DuplicatedMemberException
import com.example.domain.user.exception.IncorrectPasswordException
import com.example.domain.user.exception.UserNotFoundException
import com.example.domain.user.mapper.UserMapper
import com.example.domain.user.repository.UserJpaRepository
import com.example.domain.user.model.User
import com.example.domain.user.spi.UserPort
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userMapper: UserMapper,
    private val passwordEncoder: BCryptPasswordEncoder
): UserPort {

    override fun saveUser(user: User) {

        if(userJpaRepository.existsByAccountId(user.accountId)) {
            throw DuplicatedMemberException.EXCEPTION
        }

        userJpaRepository.save(
            userMapper.toEntity(user)
        )
    }

    override fun verifyUser(loginRequest: LoginRequest): String {

        val user = userJpaRepository.findByAccountId(loginRequest.accountId)
            ?: throw UserNotFoundException.EXCEPTION

        if(passwordEncoder.matches(loginRequest.password, user.password)){
            return user.accountId
        }

        throw IncorrectPasswordException.EXCEPTION
    }
}