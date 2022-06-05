package com.mal.cloud.future_userFiles.presentation.fileLoadStateAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.mal.cloud.databinding.ViewHolderErrorBinding
import com.mal.cloud.databinding.ViewHolderLoadingBinding
import com.mal.cloud.future_userFiles.presentation.fileLoadStateAdapter.viewHolder.BaseLoadStateViewHolder
import com.mal.cloud.future_userFiles.presentation.fileLoadStateAdapter.viewHolder.FilesErrorViewHolder
import com.mal.cloud.future_userFiles.presentation.fileLoadStateAdapter.viewHolder.FilesLoadingViewHolder
import com.mal.cloud.future_userFiles.presentation.fileLoadStateAdapter.viewHolder.FilesNotLoadingViewHolder
import javax.inject.Inject

class FilesLoadStateAdapter @Inject constructor() : LoadStateAdapter<BaseLoadStateViewHolder>() {

    override fun onBindViewHolder(holder: BaseLoadStateViewHolder, loadState: LoadState) {
        holder.onBind()
    }

    override fun getStateViewType(loadState: LoadState): Int {
        return when (loadState) {
            is LoadState.NotLoading -> 1
            LoadState.Loading -> 2
            is LoadState.Error -> 3
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): BaseLoadStateViewHolder {
        return when (loadState) {
            is LoadState.NotLoading -> {
                FilesNotLoadingViewHolder(parent)
            }
            LoadState.Loading -> {
                val binding =
                    ViewHolderLoadingBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                FilesLoadingViewHolder(binding)
            }
            is LoadState.Error -> {
                val binding =
                    ViewHolderErrorBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                FilesErrorViewHolder(binding)
            }
        }
    }
}