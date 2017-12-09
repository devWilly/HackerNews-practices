package com.devwilly.retrofit_kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.devwilly.retrofit_kotlin.R
import com.devwilly.retrofit_kotlin.viewholder.JobStoryItemViewHolder

/**
 * Created by Qoo on 09/12/2017.
 */
class JobStoryAdapter(itemList: List<Int>) : RecyclerView.Adapter<JobStoryItemViewHolder>() {

    var mDataItemList: List<Int> = ArrayList()

    init {
        mDataItemList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): JobStoryItemViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_story, parent, false)
        return JobStoryItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobStoryItemViewHolder?, position: Int) {
        holder?.itemText?.text = mDataItemList[position].toString()
    }

    override fun getItemCount(): Int {
        return mDataItemList.size
    }
}