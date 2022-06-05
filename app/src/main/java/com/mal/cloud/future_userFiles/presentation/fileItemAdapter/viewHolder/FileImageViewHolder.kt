package com.mal.cloud.future_userFiles.presentation.fileItemAdapter.viewHolder

import com.mal.cloud.databinding.ViewHolderFileImageBinding
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo

class FileImageViewHolder(
    private val binding: ViewHolderFileImageBinding
) : BaseViewHolder(binding.root) {

    override fun onBind(filesInfo: FilesInfo) {
        binding.textView.text = filesInfo.originFileName
    }
}