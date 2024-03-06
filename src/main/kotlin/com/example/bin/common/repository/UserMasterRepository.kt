package com.example.bin.common.repository

import com.example.bin.common.domain.UserMaster
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserMasterRepository : JpaRepository<UserMaster, UUID> {
    fun findByEmail(email: String): UserMaster?
}