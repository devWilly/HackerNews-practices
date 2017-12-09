package com.devwilly.retrofit_kotlin.adapter

import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.devwilly.retrofit_kotlin.R
import com.devwilly.retrofit_kotlin.model.JobDetailModel
import com.devwilly.retrofit_kotlin.viewholder.JobDetailItemViewHolder

/**
 * Created by Willy on 09/12/2017.
 */
class JobDetailAdapter(detailItemList: MutableList<JobDetailModel>): RecyclerView.Adapter<JobDetailItemViewHolder>() {

    var mDetailItemList: MutableList<JobDetailModel> = ArrayList()

    init {
        mDetailItemList = detailItemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobDetailItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_job_detail_layout, parent, false)
        return JobDetailItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobDetailItemViewHolder, position: Int) {
        val res: Resources = holder.itemView.resources
        val item: JobDetailModel = mDetailItemList[position]

        holder.jobId.text = String.format(res.getString(R.string.job_id), item.id)
        holder.jobTitle.text = String.format(res.getString(R.string.job_title), item.title)
        holder.jobText.text = String.format(res.getString(R.string.job_text), item.text)
        holder.jobType.text = String.format(res.getString(R.string.job_type), item.type)
        holder.jobTime.text = String.format(res.getString(R.string.job_time), item.time)
    }

    override fun getItemCount(): Int {
        return mDetailItemList.size
    }

}