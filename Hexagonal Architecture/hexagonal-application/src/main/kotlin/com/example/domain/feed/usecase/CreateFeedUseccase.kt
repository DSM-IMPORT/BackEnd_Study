package com.example.domain.feed.usecase

import com.example.domain.feed.dto.request.CreateFeedRequest
import com.example.domain.feed.model.Feed
import com.example.domain.feed.spi.FeedPort
import com.example.domain.user.spi.UserSecurityPort
import com.example.global.annotation.UseCase

@UseCase
class CreateFeedUseccase(
    private val feedPort: FeedPort,
    private val userSecurityPort: UserSecurityPort
) {
    fun excute(createFeedRequest: CreateFeedRequest) {
        val userId = userSecurityPort.getCurrentUserId()

        val feed = Feed(
            id = null,
            title = createFeedRequest.title,
            content = createFeedRequest.content,
            userId = userId
        )

        feedPort.saveFeed(feed)
    }
}