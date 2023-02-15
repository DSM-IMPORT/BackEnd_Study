package com.example.domain.auth.exception

import com.example.domain.user.error.RedisErrorCode
import com.example.global.error.CustomException

object RefreshTokenNotFoundException: CustomException(RedisErrorCode.REFRESH_TOKEN_NOT_FOUND)