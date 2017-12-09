package com.devwilly.retrofit_kotlin.viewholder

import android.view.View
import android.widget.TextView
import com.devwilly.retrofit_kotlin.R

/**
 * Created by Willy on 09/12/2017.
 */
class JobStoryItemViewHolder(itemView: View) : BaseItemViewHolder(itemView) {
    val itemText = itemView.findViewById<TextView>(R.id.item_story_text)
}