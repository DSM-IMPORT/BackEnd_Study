package com.example.domain.feed

import com.example.domain.feed.dto.request.CreateFeedRequest
import com.example.domain.feed.dto.request.CreateFeedWebRequest
import com.example.domain.feed.usecase.CreateFeedUseccase
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@Validated
@RequestMapping("/feed")
@RestController
class FeedWebAdapter(
    private val createFeedUseccase: CreateFeedUseccase
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createFeed(@RequestBody @Valid request: CreateFeedWebRequest) {
        createFeedUseccase.excute(
            CreateFeedRequest(
                title = request.title,
                content = request.content
            )
        )
    }
}