package com.devwilly.retrofit_kotlin.viewholder

import android.view.View
import android.widget.TextView
import com.devwilly.retrofit_kotlin.R

/**
 * Created by Willy on 09/12/2017.
 */
class JobDetailItemViewHolder(itemView: View) : BaseItemViewHolder(itemView) {

    val jobId = itemView.findViewById<TextView>(R.id.job_id)
    val jobTitle = itemView.findViewById<TextView>(R.id.job_title)
    val jobText = itemView.findViewById<TextView>(R.id.job_text)
    val jobType = itemView.findViewById<TextView>(R.id.job_type)
    val jobTime = itemView.findViewById<TextView>(R.id.job_time)
}