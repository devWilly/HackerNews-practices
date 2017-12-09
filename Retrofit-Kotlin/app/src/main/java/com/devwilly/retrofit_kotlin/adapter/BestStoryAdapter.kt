package com.devwilly.retrofit_kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.devwilly.retrofit_kotlin.R
import com.devwilly.retrofit_kotlin.viewholder.BestStoryItemViewHolder

/**
 * Created by Willy on 09/12/2017.
 */
class BestStoryAdapter(itemList: List<Int>) : RecyclerView.Adapter<BestStoryItemViewHolder>() {

    var mData: List<Int> = ArrayList()

    init {
        mData = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BestStoryItemViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_story, parent, false)
        return BestStoryItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestStoryItemViewHolder?, position: Int) {
        holder?.itemText?.text = mData[position].toString()
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}