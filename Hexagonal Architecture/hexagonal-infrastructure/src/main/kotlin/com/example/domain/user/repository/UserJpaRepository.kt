package com.example.domain.user.repository

import com.example.domain.user.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserJpaRepository : JpaRepository<UserJpaEntity, Long> {

    fun findByAccountId(accountId: String): UserJpaEntity?

    fun existsByAccountId(accountId: String): Boolean
}