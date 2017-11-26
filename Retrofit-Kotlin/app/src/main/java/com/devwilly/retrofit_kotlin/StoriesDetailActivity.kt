package com.devwilly.retrofit_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.devwilly.retrofit_kotlin.api.ApiClient
import com.devwilly.retrofit_kotlin.model.StoryDetailModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Willy on 21/11/2017.
 */
class StoriesDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_story_layout)

        val storyTitle = findViewById<TextView>(R.id.story_text)
        val sb = StringBuffer()

        ApiClient.getApiService().getTopStories().enqueue(object : Callback<List<Int>>{
            override fun onResponse(call: Call<List<Int>>?, response: Response<List<Int>>?) {
                val list = response?.body()

                list?.let {
                    val sampleList = listOf(list[0], list[1], list[2], list[3], list[4], list[5])
                    sampleList.forEach { index ->
                        ApiClient.getApiService().getStoryDetail(index)
                                .enqueue(object : Callback<StoryDetailModel> {
                                    override fun onResponse(call: Call<StoryDetailModel>?, response: Response<StoryDetailModel>?) {
                                        val item = response?.body()
                                        sb.append(item?.title).append('\n')

                                        storyTitle.text = sb.toString()
                                    }

                                    override fun onFailure(call: Call<StoryDetailModel>?, t: Throwable?) {
                                    }
                                }) }
                }
            }

            override fun onFailure(call: Call<List<Int>>?, t: Throwable?) {
            }
        })
    }
}