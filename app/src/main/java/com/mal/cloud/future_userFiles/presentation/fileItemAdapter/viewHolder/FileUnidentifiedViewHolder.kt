package com.mal.cloud.future_userFiles.presentation.fileItemAdapter.viewHolder

import com.mal.cloud.databinding.ViewHolderFileUnidentifiedBinding
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo

class FileUnidentifiedViewHolder(
    private val binding: ViewHolderFileUnidentifiedBinding
) : BaseViewHolder(binding.root) {

    override fun onBind(filesInfo: FilesInfo) {
        binding.textView.text = filesInfo.originFileName
    }
}