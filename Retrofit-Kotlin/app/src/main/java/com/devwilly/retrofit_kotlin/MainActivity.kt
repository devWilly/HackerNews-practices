package com.devwilly.retrofit_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import com.devwilly.retrofit_kotlin.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {

    val API_SERVICE_URL = " https://hacker-news.firebaseio.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storiesTextId: TextView = findViewById(R.id.stories_text_id)
        val sb = StringBuffer()

        var topStoriesListResponse: Call<List<Int>> = getApiService().getTopStories()
        topStoriesListResponse.enqueue(object: Callback<List<Int>> {
            override fun onResponse(call: Call<List<Int>>?, response: Response<List<Int>>?) {
                var list: List<Int>? = response?.body()
                sb.append(Html.fromHtml(getString(R.string.top_stories)))

                for (item in list!!) {
                    sb.append('\n').append(item)
                }

                storiesTextId.text = sb.toString()


            }

            override fun onFailure(call: Call<List<Int>>?, t: Throwable?) {

            }
        })

        val newStoriesListResponse: Call<List<Int>> = getApiService().getNewStories()
        newStoriesListResponse.enqueue(object: Callback<List<Int>>{
            override fun onResponse(call: Call<List<Int>>?, response: Response<List<Int>>?) {
                var list: List<Int>? = response?.body()
                sb.append('\n').append(getString(R.string.new_stories))

                for (item in list!!) {
                    sb.append('\n').append(item)
                }

                storiesTextId.text = sb.toString()
            }

            override fun onFailure(call: Call<List<Int>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })


    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(API_SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun getApiService(): ApiService {
        return getRetrofit().create(ApiService::class.java)
    }
}