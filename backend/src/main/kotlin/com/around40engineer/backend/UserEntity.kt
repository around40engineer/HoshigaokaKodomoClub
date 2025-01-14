package com.around40engineer.backend

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class UserEntity(
    @Id
    val id: String,
    val status: String
)
