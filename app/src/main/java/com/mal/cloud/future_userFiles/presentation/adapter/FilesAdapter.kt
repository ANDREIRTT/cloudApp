package com.mal.cloud.future_userFiles.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.mal.cloud.databinding.ViewHolderFilesBinding
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo
import com.mal.cloud.future_userFiles.presentation.adapter.viewHolder.ImageViewHolder
import javax.inject.Inject

class FilesAdapter @Inject constructor(
    filesDiffUtil: DiffUtil.ItemCallback<FilesInfo>
) : PagingDataAdapter<FilesInfo, ImageViewHolder>(filesDiffUtil) {
    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.fileType?.ordinal ?: 0
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding =
            ViewHolderFilesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }
}