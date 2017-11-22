package com.devwilly.retrofit_kotlin.model

/**
 * Created by Willy on 21/11/2017.
 */
data class StoryDetailModel(
        val id: Int,
        val descendants: Int,
        val kids: List<Int>,
        val score: Int,
        val time: Int,
        val title: String,
        val type: String,
        val url: String) {}