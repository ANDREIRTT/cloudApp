package com.mal.cloud.future_auth.data.di

import com.mal.cloud.future_auth.data.AuthRepositoryImpl
import com.mal.cloud.future_auth.data.db.AuthDataRepositoryImpl
import com.mal.cloud.future_auth.data.network.AuthHeaderInterceptor
import com.mal.cloud.future_auth.domain.repository.AuthDataRepository
import com.mal.cloud.future_auth.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.Interceptor

@Module
@InstallIn(ViewModelComponent::class)
abstract class AuthModule {
    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}