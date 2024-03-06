package com.example.bin.helloworld.domain

import com.example.bin.common.domain.CommonEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "boring_hello_world")
class BoringHelloWorld(

    @Column
    val nickName: String,

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(nullable = false)
    val helloWorld: HelloWorld
) : CommonEntity()