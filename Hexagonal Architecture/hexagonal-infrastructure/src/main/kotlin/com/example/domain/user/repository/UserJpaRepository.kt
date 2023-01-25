package com.example.domain.user.repository

import com.example.domain.user.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository : JpaRepository<UserJpaEntity, Long> {
}