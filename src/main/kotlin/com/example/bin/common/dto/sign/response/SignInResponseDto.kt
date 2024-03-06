package com.example.bin.common.dto.sign.response

import java.util.*

data class SignInResponseDto(
    val token: String,
    val utcExpirationDate: Date,
    val roles: MutableList<String>
)