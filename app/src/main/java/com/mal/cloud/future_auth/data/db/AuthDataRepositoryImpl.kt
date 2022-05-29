package com.mal.cloud.future_auth.data.db

import android.content.SharedPreferences
import com.mal.cloud.future_auth.data.di.SP_TOKEN
import com.mal.cloud.future_auth.domain.dto.UserData
import com.mal.cloud.future_auth.domain.repository.AuthDataRepository
import javax.inject.Inject

class AuthDataRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : AuthDataRepository {
    override fun isLoggedIn(): Boolean {
        val token = getUserToken()
        return token != null && token.isNotEmpty()
    }

    override suspend fun getUserData(): UserData? {
        val userToken = getUserToken()
        if (userToken != null) {
            return UserData(userToken)
        }
        return null
    }

    override fun getUserToken(): String? {
        return sharedPreferences.getString(
            SP_TOKEN, null
        )
    }

    override fun saveUserData(userData: UserData) {
        with(sharedPreferences.edit()) {
            putString(SP_TOKEN, userData.token)
            apply()
        }
    }
}