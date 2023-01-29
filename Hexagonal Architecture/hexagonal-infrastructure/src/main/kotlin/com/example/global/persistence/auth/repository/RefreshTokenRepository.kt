package com.example.global.persistence.auth.repository

import com.example.global.persistence.auth.entity.RefreshTokenEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : JpaRepository<RefreshTokenEntity, String> {
}