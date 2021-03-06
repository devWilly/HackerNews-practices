package com.devwilly.retrofit_kotlin.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Willy on 21/11/2017.
 */
class ApiClient {

    companion object {
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl("https://hacker-news.firebaseio.com/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
        }

        private fun getRetrofitWithRxJava(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl("https://hacker-news.firebaseio.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
        }

        fun getApiService(): ApiService {
            return getRetrofit().create(ApiService::class.java)
        }

        fun getApiServiceWithRx(): ApiService {
            return getRetrofitWithRxJava().create(ApiService::class.java)
        }
    }
}