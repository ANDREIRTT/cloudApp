package com.mal.cloud.future_userFiles.domain.dto

import com.mal.cloud.future_userFiles.data.network.pojo.FileType

data class FilesInfo(
    val fileHash: String,
    val fileType: FileType,
    val originFileName: String,
)