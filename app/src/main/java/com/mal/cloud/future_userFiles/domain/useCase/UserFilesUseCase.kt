package com.mal.cloud.future_userFiles.domain.useCase

import androidx.paging.PagingData
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo
import kotlinx.coroutines.flow.Flow

interface UserFilesUseCase {
    fun invoke(size: Int): Flow<PagingData<FilesInfo>>
}