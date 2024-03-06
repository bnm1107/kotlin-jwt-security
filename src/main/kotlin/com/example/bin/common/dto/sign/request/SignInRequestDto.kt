package com.example.bin.common.dto.sign.request

import jakarta.validation.constraints.Email

data class SignInRequestDto (
    @Email
    var email: String,
    var password: String
) {

}