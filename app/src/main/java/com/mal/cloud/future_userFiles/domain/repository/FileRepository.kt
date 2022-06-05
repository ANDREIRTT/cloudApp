package com.mal.cloud.future_userFiles.domain.repository

import androidx.paging.PagingData
import com.mal.cloud.future_userFiles.data.network.pojo.StorageFile
import kotlinx.coroutines.flow.Flow

interface FileRepository {
    fun getUserFiles(size: Int): Flow<PagingData<StorageFile>>
}