package com.mal.cloud.future_userFiles.data.network.pojo

data class StorageFile(
    val fileHash: String,
    val originFileName: String,
    val fileType: FileType
)