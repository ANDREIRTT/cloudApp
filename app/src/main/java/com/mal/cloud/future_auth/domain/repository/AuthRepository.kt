package com.mal.cloud.future_auth.domain.repository

import com.mal.cloud.future_auth.domain.dto.AuthResponse
import com.mal.cloud.future_auth.domain.dto.UserRole

interface AuthRepository {

    suspend fun login(username: String, password: String): AuthResponse

    suspend fun register(username: String, password: String, userRole: UserRole): AuthResponse
}