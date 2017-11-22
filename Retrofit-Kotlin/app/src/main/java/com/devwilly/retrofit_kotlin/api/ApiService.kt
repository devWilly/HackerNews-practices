package com.devwilly.retrofit_kotlin.api

import com.devwilly.retrofit_kotlin.model.StoryDetailModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Willy on 20/11/2017.
 */

interface ApiService {

    @GET("v0/topstories.json?print=pretty")
    fun getTopStories(): Call<List<Int>>

    @GET("v0/newstories.json?print=pretty")
    fun getNewStories(): Call<List<Int>>

    @GET("v0/beststories.json?print=pretty")
    fun getBestStories(): Call<List<Int>>

    @GET("v0/item/{id}.json?print=pretty")
    fun getStoryDetail(@Path("id") id: Int): Call<StoryDetailModel>
}