package com.mal.cloud.future_auth.presentation.di

import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mal.cloud.future_auth.presentation.dialog.AuthDialogFragment
import com.mal.cloud.future_auth.presentation.fragment.AuthFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class FragmentModule {

    @Provides
    fun getBottomSheetDialogFragment(): BottomSheetDialogFragment {
        return AuthDialogFragment()
    }

    @Provides
    @com.mal.cloud.core.di.fragmentQualifiers.AuthFragment
    fun getAuthFragment(): Fragment {
        return AuthFragment()
    }
}