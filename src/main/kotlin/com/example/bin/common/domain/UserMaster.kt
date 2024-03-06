package com.example.bin.common.domain

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
@Table(name ="user_master")
class UserMaster
    (

    @Column(unique = true, length = 100, nullable = false)
    val email: String,

    @Column(length = 100, nullable = false)
    private val password: String,

    @Column(length = 50, nullable = false)
    val nickName: String,

    @Column(length = 50, nullable = false)
    val createUser: String,

    @Column(length = 50, nullable = false)
    val updateUser: String,

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "user_master_rules",
        joinColumns = [JoinColumn(name = "user_master_id")])
    @Column(nullable = false)
    val roles: MutableList<String>


    ): BaseEntity(), UserDetails {
        override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
            return roles
                .map { _role -> SimpleGrantedAuthority(_role) }
                .toMutableList()
        }

        override fun getUsername(): String = email

        override fun getPassword(): String = password

        override fun isAccountNonExpired(): Boolean = false

        override fun isAccountNonLocked(): Boolean = true

        override fun isCredentialsNonExpired(): Boolean = true

        override fun isEnabled(): Boolean = true

    }