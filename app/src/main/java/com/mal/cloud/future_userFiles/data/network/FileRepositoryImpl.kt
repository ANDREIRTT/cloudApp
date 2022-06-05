package com.mal.cloud.future_userFiles.data.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.mal.cloud.future_userFiles.data.network.paging.FilePagingSource
import com.mal.cloud.future_userFiles.domain.repository.FileRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FileRepositoryImpl @Inject constructor(
    private val filePagingSource: FilePagingSource,
    private val coroutineDispatcher: CoroutineDispatcher
) : FileRepository {
    override fun getUserFiles(size: Int) = Pager(
        PagingConfig(
            pageSize = size,
            enablePlaceholders = false
        )
    ) {
        filePagingSource
    }.flow.flowOn(coroutineDispatcher)

}