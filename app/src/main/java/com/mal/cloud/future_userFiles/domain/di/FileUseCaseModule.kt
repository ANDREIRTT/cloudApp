package com.mal.cloud.future_userFiles.domain.di

import com.mal.cloud.future_userFiles.domain.useCase.UserFilesUseCase
import com.mal.cloud.future_userFiles.domain.useCase.UserFilesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class FileUseCaseModule {

    @Binds
    abstract fun fileUseCase(userFilesUseCaseImpl: UserFilesUseCaseImpl): UserFilesUseCase
}