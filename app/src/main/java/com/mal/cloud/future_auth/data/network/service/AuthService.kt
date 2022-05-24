package com.mal.cloud.future_auth.data.network.service

import com.mal.cloud.future_auth.data.network.pojo.AuthResponseData
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface AuthService {

    @Multipart
    @POST("account/login")
    suspend fun login(
        @Part("username") username: RequestBody,
        @Part("password") password: RequestBody
    ): Response<AuthResponseData>

    @Multipart
    @POST("account/register")
    suspend fun register(
        @Part("username") username: RequestBody,
        @Part("password") password: RequestBody,
        @Part("userRole") userRole: RequestBody
    ): Response<AuthResponseData>
}