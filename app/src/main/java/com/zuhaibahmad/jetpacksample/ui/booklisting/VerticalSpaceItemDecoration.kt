package com.zuhaibahmad.jetpacksample.ui.booklisting

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalSpaceItemDecoration(private val dividedViewHolderClass: Class<out RecyclerView.ViewHolder>,
    private val dividerHeight: Int) : RecyclerView.ItemDecoration() {

    override
    fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val viewHolder = parent.getChildViewHolder(view)
        if (viewHolder.javaClass == dividedViewHolderClass) {
            outRect.bottom = dividerHeight
        }
    }
}