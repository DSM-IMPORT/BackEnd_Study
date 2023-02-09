package com.example.domain.user.exception

import com.example.domain.user.error.UserErrorCode
import com.example.global.error.CustomException

object UserNotFoundException: CustomException(UserErrorCode.USER_NOT_FOUND)