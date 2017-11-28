package com.devwilly.retrofit_kotlin.model

/**
 * Created by Willy on 28/11/2017.
 */
data class JobDetailModel(
        val by: String,
        val id: Int,
        val score: Int,
        val text: String,
        val time: Int,
        val title: String,
        val type: String,
        val url: String) {}