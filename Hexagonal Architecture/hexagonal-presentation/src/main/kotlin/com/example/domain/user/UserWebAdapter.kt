package com.example.domain.user

import com.example.domain.auth.dto.response.TokenResponse
import com.example.domain.user.dto.LoginRequest
import com.example.domain.user.dto.LoginWebRequest
import com.example.domain.user.dto.SignupRequest
import com.example.domain.user.dto.SignupWebRequest
import com.example.domain.user.usecase.LoginUseCase
import com.example.domain.user.usecase.SignupUseCase
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import com.example.domain.user.dto.response.QueryUserMyInfoResponse
import com.example.domain.user.usecase.QueryMyInfoUseCase

@Validated
@RestController
@RequestMapping("/users")
class UserWebAdapter(
    private val signupUseCase: SignupUseCase,

    private val loginUseCase: LoginUseCase
    
    private val queryMyInfoUseCase: QueryMyInfoUseCase
) {

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.CREATED)
    fun signup(
        @RequestBody @Valid
        request: SignupWebRequest
    ) {
        signupUseCase.execute(
            SignupRequest(
            request.accountId,
            request.password,
            request.name,
            request.age
            )
        )
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    fun login(
        @RequestBody @Valid
        req: LoginWebRequest
    ):TokenResponse {
        return loginUseCase.execute(
            LoginRequest(
                req.accountId,
                req.password
            )
        )
    }

    @GetMapping("/my")
    fun myPage(): QueryUserMyInfoResponse {
        return queryMyInfoUseCase.execute()
    }
}