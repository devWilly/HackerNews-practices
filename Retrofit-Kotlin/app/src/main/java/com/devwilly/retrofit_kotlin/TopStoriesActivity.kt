package com.devwilly.retrofit_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.devwilly.retrofit_kotlin.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Willy on 21/11/2017.
 */
class TopStoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_story_layout)

        val storyText = findViewById<TextView>(R.id.story_text)
        val sb = StringBuffer()

        ApiClient.getApiService().getTopStories().enqueue(object : Callback<List<Int>>{
            override fun onResponse(call: Call<List<Int>>?, response: Response<List<Int>>?) {
                sb.append(getString(R.string.top_stories))

                val list = response?.body()

                if (list != null) {
                    for (item in list) {
                        sb.append('\n').append(item)
                    }
                }

                storyText.text = sb.toString()
            }

            override fun onFailure(call: Call<List<Int>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}