package com.mal.cloud.future_auth.domain.repository

import com.mal.cloud.future_auth.domain.dto.UserData


interface AuthDataRepository {
    fun isLoggedIn(): Boolean

    suspend fun getUserData(): UserData?

    fun getUserToken(): String?

    fun saveUserData(userData: UserData)
}