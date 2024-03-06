package com.example.bin.helloworld.domain

import com.example.bin.common.domain.CommonEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.PostLoad
import jakarta.persistence.PostPersist
import jakarta.persistence.Table
import org.springframework.data.domain.Persistable
import java.util.UUID

@Entity
@Table(name = "Foo")
class HelloWorld (
    @Column
    val name: String
) : CommonEntity() {

    @Column
    var age: Int = 0

}