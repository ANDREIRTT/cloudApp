package com.mal.cloud.future_auth.data.di

import com.mal.cloud.future_auth.data.db.AuthDataRepositoryImpl
import com.mal.cloud.future_auth.data.network.AuthHeaderInterceptor
import com.mal.cloud.future_auth.domain.repository.AuthDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {
    @Binds
    abstract fun bindAuthDataRepository(authDataRepositoryImpl: AuthDataRepositoryImpl): AuthDataRepository

    @Binds
    abstract fun bindAuthInterceptor(authHeaderInterceptor: AuthHeaderInterceptor): Interceptor
}