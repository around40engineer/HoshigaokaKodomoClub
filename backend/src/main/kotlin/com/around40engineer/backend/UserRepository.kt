package com.around40engineer.backend

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<UserEntity, String> {
}