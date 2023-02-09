package com.example.domain.user.dto.response

data class QueryUserMyInfoResponse(
    val accountId: String,
    val name: String,
    val age: Int,
    val feeds: List<FeedResponse>
) {
    data class FeedResponse(
        val feedId: Long,
        val title: String
    )
}

