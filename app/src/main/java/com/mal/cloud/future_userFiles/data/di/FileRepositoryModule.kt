package com.mal.cloud.future_userFiles.data.di

import com.mal.cloud.future_userFiles.data.network.FileRepositoryImpl
import com.mal.cloud.future_userFiles.domain.repository.FileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class FileRepositoryModule {

    @Binds
    abstract fun fileRepository(fileRepositoryImpl: FileRepositoryImpl): FileRepository
}