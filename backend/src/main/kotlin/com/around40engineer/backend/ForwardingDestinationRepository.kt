package com.around40engineer.backend

import org.springframework.data.jpa.repository.JpaRepository

interface ForwardingDestinationRepository: JpaRepository<ForwardingDestinationEntity, Int> {
    fun findForwardingDestinationEntityByEmail(email: String): ForwardingDestinationEntity?
}