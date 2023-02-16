package com.example.domain.feed.spi

import com.example.domain.feed.model.Feed

interface FeedPort {
    fun findAllByUserId(userId: Long): List<Feed>
    fun saveFeed(feed: Feed)
}