package com.devwilly.retrofit_kotlin.viewholder

import android.view.View
import android.widget.TextView
import com.devwilly.retrofit_kotlin.R

/**
 * Created by Willy on 05/12/2017.
 */
class TopStoryItemViewHolder(itemView: View) : BaseItemViewHolder(itemView) {
    val text: TextView = itemView.findViewById(R.id.item_story_text)
}