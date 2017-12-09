package com.devwilly.retrofit_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.devwilly.retrofit_kotlin.api.ApiClient
import com.devwilly.retrofit_kotlin.adapter.TopStoryAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Willy on 21/11/2017.
 */
class TopStoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_recyclerview_layout)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        ApiClient.getApiService().getTopStories().enqueue(object : Callback<List<Int>>{
            override fun onResponse(call: Call<List<Int>>?, response: Response<List<Int>>?) {

                val list = response?.body()

                list?.let {
                    recyclerView.adapter = TopStoryAdapter(list)
                }
            }

            override fun onFailure(call: Call<List<Int>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}