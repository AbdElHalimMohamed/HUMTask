package com.halim.humtask.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View


abstract class BaseViewHolder<in T>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(model: T)
}