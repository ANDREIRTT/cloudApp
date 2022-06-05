package com.mal.cloud.future_userFiles.presentation.fileItemAdapter.viewHolder

import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.mal.cloud.core.di.retrofit.FILE_URL
import com.mal.cloud.databinding.ViewHolderFileImageBinding
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo


class FileImageViewHolder(
    private val binding: ViewHolderFileImageBinding,
    private val lazyHeaders: LazyHeaders
) : BaseViewHolder(binding.root) {

    override fun onBind(filesInfo: FilesInfo) {
        val url = GlideUrl(
            "${FILE_URL}/" + filesInfo.fileHash,
            lazyHeaders
        )

        Glide.with(binding.root)
            .load(url)
            .into(binding.imageView)
        binding.textView.text = filesInfo.originFileName
    }
}