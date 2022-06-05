package com.mal.cloud.future_userFiles.presentation.di

import androidx.recyclerview.widget.DiffUtil
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo
import com.mal.cloud.future_userFiles.presentation.fileItemAdapter.diffUtil.FilesDiffUtil
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class FilesPresentationModule {

    @Binds
    abstract fun diffUtil(filesDiffUtil: FilesDiffUtil): DiffUtil.ItemCallback<FilesInfo>
}