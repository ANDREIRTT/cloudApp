package com.mal.cloud.future_userFiles.presentation.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.mal.cloud.databinding.ViewHolderFilesBinding
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo

class ImageViewHolder(
    private val binding: ViewHolderFilesBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(filesInfo: FilesInfo) {
        binding.textView.text = filesInfo.originFileName
    }
}