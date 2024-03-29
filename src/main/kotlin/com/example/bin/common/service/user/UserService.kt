package com.example.bin.common.service.user

import com.example.bin.common.dto.user.UsersResponseDto
import com.example.bin.common.repository.UserMasterRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userMasterRepository: UserMasterRepository
) {

    fun getAllUsers(): MutableList<UsersResponseDto> {
        val usersResponse: MutableList<UsersResponseDto> = mutableListOf()

        userMasterRepository.findAll().map {
                userMaster ->
            usersResponse.add(
                UsersResponseDto(
                    email = userMaster.email,
                    nickName = userMaster.nickName,
                    roles = userMaster.roles
                )
            )
        }

        return usersResponse
    }
}