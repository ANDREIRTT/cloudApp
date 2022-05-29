package com.mal.cloud.future_auth.data.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

const val SP_AUTH = "spAuthName"
const val SP_TOKEN = "spToken"

@Module
@InstallIn(SingletonComponent::class)
class SpDataModule {
    @Provides
    fun getSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(SP_AUTH, Context.MODE_PRIVATE)
    }
}