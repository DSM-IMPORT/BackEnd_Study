package com.example.domain.user

import com.example.domain.user.dto.SignupWebRequest
import com.example.domain.user.dto.SignupRequest
import com.example.domain.user.usecase.SignupUseCase
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping("/users")
class UserWebAdapter(
    private val signupUseCase: SignupUseCase
) {

    @PostMapping("/auth")
    fun signup(@RequestBody @Valid request: SignupWebRequest) {
        signupUseCase.execute(
            SignupRequest(
            accountId = request.accountId,
            password = request.password,
            name = request.name,
            age = request.age
            )
        )
    }
}