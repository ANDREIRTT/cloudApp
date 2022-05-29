package com.mal.cloud.future_auth.data.network

import com.mal.cloud.future_auth.domain.repository.AuthDataRepository
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

private const val BEARER = "Bearer "

private const val HEADER = "Authorization"

class AuthHeaderInterceptor @Inject constructor(
    private val authDataRepository: AuthDataRepository
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(HEADER, BEARER + authDataRepository.getUserToken())
            .build()
        return chain.proceed(request)
    }
}