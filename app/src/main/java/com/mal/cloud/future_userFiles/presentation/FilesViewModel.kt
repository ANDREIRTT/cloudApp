package com.mal.cloud.future_userFiles.presentation

import androidx.lifecycle.ViewModel
import com.mal.cloud.future_userFiles.domain.useCase.UserFilesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilesViewModel @Inject constructor(
    private val filesUseCase: UserFilesUseCase
) : ViewModel() {

    val liveData = filesUseCase.invoke(10)
}