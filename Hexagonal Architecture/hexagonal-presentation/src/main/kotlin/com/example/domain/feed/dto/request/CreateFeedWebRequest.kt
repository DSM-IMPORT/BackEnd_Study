package com.example.domain.feed.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateFeedWebRequest(
    @field:NotBlank
    @field:Size(max = 150)
    val title: String,

    @field:NotBlank
    @field:Size(max = 2000)
    val content: String
)