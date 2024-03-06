package com.example.bin.helloworld.repository

import com.example.bin.helloworld.domain.BoringHelloWorld
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BoringHelloWorldRepository :
    JpaRepository<BoringHelloWorld,UUID>