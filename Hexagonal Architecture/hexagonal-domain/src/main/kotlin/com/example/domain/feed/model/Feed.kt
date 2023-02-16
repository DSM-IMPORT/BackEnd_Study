package com.example.domain.feed.model

import com.example.global.annotation.Aggregate

@Aggregate
data class Feed(
    val id: Long?,
    val title: String,
    val content: String,
    val userId: Long
)
