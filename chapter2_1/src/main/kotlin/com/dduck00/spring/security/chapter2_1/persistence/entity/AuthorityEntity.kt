package com.dduck00.spring.security.chapter2_1.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "authorities")
@Entity
data class AuthorityEntity(
    @Id
    val id: Int,
    val username: String,
    val authority: String,
)
