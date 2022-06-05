package com.mal.cloud.core.di.retrofit

import com.google.gson.Gson
import com.mal.cloud.future_auth.data.network.AuthHeaderInterceptor
import com.mal.cloud.future_auth.data.network.service.AuthService
import com.mal.cloud.future_userFiles.data.network.service.FileService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun retrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun getAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    fun getFileService(retrofit: Retrofit): FileService {
        return retrofit.create(FileService::class.java)
    }

    @Provides
    @Singleton
    fun getFormDataMediaType(): MediaType {
        return MediaType.parse("multipart/form-data")!!
    }

    @Provides
    @Singleton
    fun getGson(): Gson {
        return Gson()
    }

    @Provides
    fun getOkHttp(authHeaderInterceptor: AuthHeaderInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authHeaderInterceptor)
            .build()
    }
}