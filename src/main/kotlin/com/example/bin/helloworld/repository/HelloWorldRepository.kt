package com.example.bin.helloworld.repository

import com.example.bin.helloworld.domain.HelloWorld
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface HelloWorldRepository : JpaRepository<HelloWorld, UUID>