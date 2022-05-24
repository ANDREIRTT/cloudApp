package com.mal.cloud.future_auth.domain

import com.mal.cloud.future_auth.domain.dto.AuthResponse
import com.mal.cloud.future_auth.domain.dto.UserRole
import com.mal.cloud.future_auth.domain.repository.AuthRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject


class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend fun login(username: String, password: String): AuthResponse {
        return authRepository.login(username, password)
    }

    suspend fun register(username: String, password: String, userRole: UserRole): AuthResponse {
        return authRepository.register(username, password, userRole)
    }
}