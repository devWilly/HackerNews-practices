package com.devwilly.retrofit_kotlin.data

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.devwilly.retrofit_kotlin.R
import com.devwilly.retrofit_kotlin.viewholder.TopStoryItemViewHolder

/**
 * Created by Willy on 05/12/2017.
 */
class TopStoryAdapter(itemList: List<Int>) : RecyclerView.Adapter<TopStoryItemViewHolder>() {

    var mDataList: List<Int> = ArrayList<Int>()

    init {
        mDataList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TopStoryItemViewHolder {
        return TopStoryItemViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_story, parent, false))
    }

    override fun onBindViewHolder(holder: TopStoryItemViewHolder?, position: Int) {
        holder?.text?.text = mDataList[position].toString()
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }
}