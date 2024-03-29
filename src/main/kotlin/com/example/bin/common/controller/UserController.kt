package com.example.bin.common.controller

import com.example.bin.common.dto.user.UsersResponseDto
import com.example.bin.common.model.response.MutableListResult
import com.example.bin.common.service.response.ResponseService
import com.example.bin.common.service.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users/v1")
class UserController(
    private val userService: UserService,
    private val responseService: ResponseService
) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<MutableListResult<UsersResponseDto>> {
        return ResponseEntity.ok()
            .body(responseService.mutableListResult(
                userService.getAllUsers()
            ))
    }
}