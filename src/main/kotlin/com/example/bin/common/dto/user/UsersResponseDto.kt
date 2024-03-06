package com.example.bin.common.dto.user

data class UsersResponseDto(
    val email: String,
    val nickName: String,
    val roles: MutableList<String>
)