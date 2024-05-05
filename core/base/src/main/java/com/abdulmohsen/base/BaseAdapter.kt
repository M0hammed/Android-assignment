package com.abdulmohsen.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<item> : RecyclerView.Adapter<BaseViewHolder<item>>() {
    protected var data: MutableList<item> = arrayListOf()

    fun addAll(insertedItemList: List<item>) {
        val dataSize = data.size
        data.addAll(insertedItemList)
        notifyItemRangeInserted(dataSize, insertedItemList.count())
    }
}