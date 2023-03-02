package com.example.domain.feed.mapper

import com.example.domain.feed.entity.FeedJpaEntity
import com.example.domain.feed.model.Feed
import com.example.domain.user.repository.UserJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FeedMapper(
    private val userJpaRepository: UserJpaRepository
) {
    fun toEntity(feed: Feed): FeedJpaEntity {
        val user = userJpaRepository.findByIdOrNull(feed.userId)
        return FeedJpaEntity(
            id = feed.id,
            title = feed.title,
            content = feed.content,
            user = user
        )
    }

    fun toDomain(feedJpaEntity: FeedJpaEntity?): Feed? {
        return feedJpaEntity?.let {
            Feed(
                id = it.id!!,
                title = it.title,
                content = it.content,
                userId = it.user!!.id!!
            )
        }
    }
}