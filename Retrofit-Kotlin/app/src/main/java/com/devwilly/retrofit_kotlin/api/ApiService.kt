package com.devwilly.retrofit_kotlin.api

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Willy on 20/11/2017.
 */

interface ApiService {

    @GET("v0/topstories.json?print=pretty")
    fun getTopStories(): Call<List<Int>>

    @GET("v0/newstories.json?print=pretty")
    fun getgetNewStories(): Call<List<Int>>

    @GET("v0/beststories.json?print=pretty")
    fun getBestStories(): Call<List<Int>>
}