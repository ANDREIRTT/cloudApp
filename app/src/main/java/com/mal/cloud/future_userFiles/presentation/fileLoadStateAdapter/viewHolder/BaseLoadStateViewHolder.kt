package com.mal.cloud.future_userFiles.presentation.fileLoadStateAdapter.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseLoadStateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind()
}