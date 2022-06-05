package com.mal.cloud.future_userFiles.presentation.adapter.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo
import javax.inject.Inject

class FilesDiffUtil @Inject constructor() : DiffUtil.ItemCallback<FilesInfo>() {
    override fun areItemsTheSame(oldItem: FilesInfo, newItem: FilesInfo): Boolean {
        return oldItem.fileHash == newItem.fileHash
    }

    override fun areContentsTheSame(oldItem: FilesInfo, newItem: FilesInfo): Boolean {
        return oldItem == newItem
    }
}