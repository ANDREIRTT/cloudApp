package com.mal.cloud.core.di.retrofit

import com.bumptech.glide.load.model.LazyHeaders
import com.mal.cloud.future_auth.domain.repository.AuthDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent


@Module
@InstallIn(FragmentComponent::class)
class GlideModule {

    @Provides
    fun getGlideHeader(authDataRepository: AuthDataRepository): LazyHeaders {
        return LazyHeaders.Builder()
            .addHeader(HEADER, BEARER + authDataRepository.getUserToken())
            .build()
    }
}