package com.example.domain.user.usecase

import com.example.domain.feed.spi.FeedPort
import com.example.domain.user.dto.response.QueryUserMyInfoResponse.FeedResponse
import com.example.domain.user.dto.response.QueryUserMyInfoResponse
import com.example.domain.user.exception.UserNotFoundException
import com.example.domain.user.spi.UserPort
import com.example.domain.user.spi.UserSecurityPort
import com.example.global.annotation.UseCase

@UseCase
class QueryMyInfoUseCase(
    private val userPort: UserPort,
    private val feedPort: FeedPort,
    private val userSecurityPort: UserSecurityPort
) {

    fun execute(): QueryUserMyInfoResponse {
        val userId = userSecurityPort.getCurrentUserId()
        val user = userPort.findByAccountId(userId)?: throw UserNotFoundException
        val feeds = feedPort.findAllByUserId(user.id!!)
            .map {
                FeedResponse(
                    title = it.title,
                    feedId = it.id!!
                )
            }

        return QueryUserMyInfoResponse(
            user.accountId,
            user.name,
            user.age,
            feeds
        )
    }
}