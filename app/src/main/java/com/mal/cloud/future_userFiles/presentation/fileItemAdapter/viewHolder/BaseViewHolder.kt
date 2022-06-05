package com.mal.cloud.future_userFiles.presentation.fileItemAdapter.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mal.cloud.future_userFiles.domain.dto.FilesInfo

abstract class BaseViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(filesInfo: FilesInfo)
}