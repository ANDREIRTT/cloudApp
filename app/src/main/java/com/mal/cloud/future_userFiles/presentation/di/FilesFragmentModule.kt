package com.mal.cloud.future_userFiles.presentation.di

import androidx.fragment.app.Fragment
import com.mal.cloud.future_userFiles.presentation.FilesFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class FilesFragmentModule {
    @Provides
    @com.mal.cloud.core.di.fragmentQualifiers.FilesFragment
    fun getFilesFragment(): Fragment {
        return FilesFragment()
    }
}