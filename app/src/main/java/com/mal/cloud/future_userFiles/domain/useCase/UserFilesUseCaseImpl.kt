package com.mal.cloud.future_userFiles.domain.useCase

import androidx.paging.PagingData
import androidx.paging.map
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo
import com.mal.cloud.future_userFiles.domain.repository.FileRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserFilesUseCaseImpl @Inject constructor(
    private val fileRepository: FileRepository,
) : UserFilesUseCase {
    override fun invoke(size: Int): Flow<PagingData<FilesInfo>> {
        return fileRepository.getUserFiles(size).map { pagingData ->
            pagingData.map {
                FilesInfo(
                    it.fileHash,
                    it.fileType,
                    it.originFileName
                )
            }
        }
    }
}