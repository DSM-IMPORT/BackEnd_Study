package com.example.domain.feed

import com.example.domain.feed.mapper.FeedMapper
import com.example.domain.feed.model.Feed
import com.example.domain.feed.repository.FeedJpaRepository
import com.example.domain.feed.spi.FeedPort
import com.example.domain.user.exception.DuplicatedMemberException
import com.example.domain.user.model.User
import org.springframework.stereotype.Component

@Component
class FeedPersistenceAdapter(
    private val feedJpaRepository: FeedJpaRepository,
    private val feedMapper: FeedMapper
): FeedPort {
    override fun findAllByUserId(userId: Long): List<Feed> {

        return feedJpaRepository.findAllByUserId(userId)
            .map {
                feedMapper.toDomain(it)!!
            }
    }

    override fun saveFeed(feed: Feed) {

        feedJpaRepository.save(
            feedMapper.toEntity(feed)
        )
    }
}