package com.dduck00.spring.security.chapter2_1.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "user")
@Entity
data class UserEntity(
    @Id val id: Int = 0,
    val username: String,
    val password: String,
    val enabled: Boolean,
)
