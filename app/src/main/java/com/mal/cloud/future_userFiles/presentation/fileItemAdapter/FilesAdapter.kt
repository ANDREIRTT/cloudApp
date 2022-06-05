package com.mal.cloud.future_userFiles.presentation.fileItemAdapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.mal.cloud.databinding.ViewHolderFileImageBinding
import com.mal.cloud.databinding.ViewHolderFileUnidentifiedBinding
import com.mal.cloud.future_userFiles.data.network.pojo.FileType
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo
import com.mal.cloud.future_userFiles.presentation.fileItemAdapter.viewHolder.BaseViewHolder
import com.mal.cloud.future_userFiles.presentation.fileItemAdapter.viewHolder.FileImageViewHolder
import com.mal.cloud.future_userFiles.presentation.fileItemAdapter.viewHolder.FileUnidentifiedViewHolder
import javax.inject.Inject

class FilesAdapter @Inject constructor(
    filesDiffUtil: DiffUtil.ItemCallback<FilesInfo>
) : PagingDataAdapter<FilesInfo, BaseViewHolder>(filesDiffUtil) {
    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.fileType?.ordinal ?: 0
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            FileType.IMAGE.ordinal -> createImageViewHolder(parent)
            else -> {
                return createUnidentifiedViewHolder(parent)
            }
        }
    }

    private fun createImageViewHolder(parent: ViewGroup): BaseViewHolder {
        val binding =
            ViewHolderFileImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return FileImageViewHolder(binding)
    }

    private fun createUnidentifiedViewHolder(parent: ViewGroup): BaseViewHolder {
        val binding =
            ViewHolderFileUnidentifiedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return FileUnidentifiedViewHolder(binding)
    }
}