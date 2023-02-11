package com.example.domain.user

import com.example.domain.user.dto.LoginWebRequest
import com.example.domain.user.dto.ReissueWebRequest
import com.example.domain.user.dto.SignupWebRequest
import com.example.domain.user.dto.request.LoginRequest
import com.example.domain.user.dto.request.ReissueRequest
import com.example.domain.user.dto.request.SignupRequest
import com.example.domain.user.usecase.LoginUseCase
import com.example.domain.user.usecase.QueryMyInfoUseCase
import com.example.domain.user.usecase.ReissueUseCase
import com.example.domain.user.usecase.SignupUseCase
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Validated
@RestController
@RequestMapping("/users")
class UserWebAdapter(
    private val signupUseCase: SignupUseCase,

    private val loginUseCase: LoginUseCase,
    
    private val queryMyInfoUseCase: QueryMyInfoUseCase,

    private val reissueUseCase: ReissueUseCase
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
    ) = loginUseCase.execute(
        LoginRequest(
            req.accountId,
            req.password
        )
    )

    @PostMapping("/reissue")
    @ResponseStatus(HttpStatus.CREATED)
    fun reissue(
        @RequestBody
        req: ReissueWebRequest
    ) = reissueUseCase.reissue(
        ReissueRequest(
            req.refreshToken
        )
    )

    @GetMapping("/my")
    fun myPage() = queryMyInfoUseCase.execute()
}