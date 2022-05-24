package com.mal.cloud.future_auth.domain.dto

sealed interface AuthResponse {

    data class Success(val userData: UserData) : AuthResponse

    data class Error(val authErrorData: AuthErrorData) : AuthResponse
}

data class UserData(
    val token: String
)

data class AuthErrorData(
    val message: String?,
)