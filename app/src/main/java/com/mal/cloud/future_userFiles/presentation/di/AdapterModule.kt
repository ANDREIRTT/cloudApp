package com.mal.cloud.future_userFiles.presentation.di

import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.load.model.LazyHeaders
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo
import com.mal.cloud.future_userFiles.presentation.fileItemAdapter.FilesAdapter
import com.mal.cloud.future_userFiles.presentation.fileLoadStateAdapter.FilesLoadStateAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class AdapterModule {

    @Provides
    @FragmentScoped
    fun getFilesAdapter(filesDiffUtil: DiffUtil.ItemCallback<FilesInfo>, lazyHeaders: LazyHeaders): FilesAdapter {
        return FilesAdapter(filesDiffUtil, lazyHeaders)
    }

    @Provides
    @FragmentScoped
    fun getLoadStateAdapter(): FilesLoadStateAdapter {
        return FilesLoadStateAdapter()
    }

    @Provides
    @FragmentScoped
    fun getConcatAdapter(
        filesAdapter: FilesAdapter,
        filesLoadStateAdapter: FilesLoadStateAdapter
    ): ConcatAdapter {
        return ConcatAdapter(filesAdapter, filesLoadStateAdapter)
    }
}