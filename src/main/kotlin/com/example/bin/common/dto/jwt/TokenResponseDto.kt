package com.example.bin.common.dto.jwt

import java.util.*

data class TokenResponseDto(
    val token: String,
    val utcExpirationDate: Date,
    val roles: MutableList<String>
)