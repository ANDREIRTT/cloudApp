package com.mal.cloud.future_auth.data

import com.google.gson.Gson
import com.mal.cloud.future_auth.data.network.pojo.AuthErrorResponse
import com.mal.cloud.future_auth.data.network.pojo.AuthResponseData
import com.mal.cloud.future_auth.data.network.service.AuthService
import com.mal.cloud.future_auth.domain.dto.AuthErrorData
import com.mal.cloud.future_auth.domain.dto.AuthResponse
import com.mal.cloud.future_auth.domain.dto.UserData
import com.mal.cloud.future_auth.domain.dto.UserRole
import com.mal.cloud.future_auth.domain.repository.AuthDataRepository
import com.mal.cloud.future_auth.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService,
    private val authDataRepository: AuthDataRepository,
    private val mediaType: MediaType,
    private val gson: Gson,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthRepository {

    override suspend fun login(username: String, password: String): AuthResponse {
        return withContext(dispatcher) {
            try {
                val response = authService.login(
                    RequestBody.create(mediaType, username),
                    RequestBody.create(mediaType, password)
                )
                parseResponse(response)
            } catch (e: HttpException) {
                AuthResponse.Error(
                    AuthErrorData(e.message)
                )
            } catch (e: Throwable) {
                AuthResponse.Error(
                    AuthErrorData(null)
                )
            }
        }
    }

    override suspend fun register(
        username: String,
        password: String,
        userRole: UserRole
    ): AuthResponse {
        return withContext(dispatcher) {
            try {
                val response = authService.register(
                    RequestBody.create(mediaType, username),
                    RequestBody.create(mediaType, password),
                    RequestBody.create(mediaType, userRole.name)
                )
                parseResponse(response)
            } catch (e: HttpException) {
                AuthResponse.Error(
                    AuthErrorData(e.message)
                )
            } catch (e: Throwable) {
                AuthResponse.Error(
                    AuthErrorData(null)
                )
            }
        }
    }

    private fun parseResponse(response: Response<AuthResponseData>): AuthResponse {
        return when {
            response.isSuccessful && response.body() != null -> {
                val userData = UserData(response.body()!!.token)
                authDataRepository.saveUserData(userData)
                AuthResponse.Success(userData)
            }
            response.errorBody() != null -> {
                val authErrorResponse = getAuthErrorResponse(response.errorBody()?.string()!!)
                AuthResponse.Error(
                    AuthErrorData(authErrorResponse.message)
                )
            }
            else -> {
                throw Exception("error response")
            }
        }

    }

    private fun getAuthErrorResponse(response: String) =
        gson.fromJson(response, AuthErrorResponse::class.java)
}