package com.around40engineer.backend

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class ForwardingDestinationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int = 0,
    val email: String
)
