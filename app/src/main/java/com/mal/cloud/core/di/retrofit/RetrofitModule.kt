package com.mal.cloud.core.di.retrofit

import com.google.gson.Gson
import com.mal.cloud.future_auth.data.network.AuthHeaderInterceptor
import com.mal.cloud.future_auth.data.network.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
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
            .baseUrl("http://mal-dev.ru")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun getAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
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