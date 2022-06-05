package com.mal.cloud.future_userFiles.data.network.pojo

data class FileResponse(
    val page: Int,
    val size: Int,
    val isLastPage: Boolean,
    val storageFile: List<StorageFile>
)