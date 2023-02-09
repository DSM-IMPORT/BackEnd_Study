package com.example.domain.feed.repository

import com.example.domain.feed.entity.FeedJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FeedJpaRepository : JpaRepository<FeedJpaEntity, Long> {
    @Query("select f from FeedJpaEntity f where f.user.id = ?1")
    fun findAllByUserId(userId: Long): List<FeedJpaEntity>
}