package com.devwilly.retrofit_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.devwilly.retrofit_kotlin.adapter.JobStoryAdapter
import com.devwilly.retrofit_kotlin.api.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Willy on 27/11/2017.
 */
class JobStoriesActivity : AppCompatActivity() {

    val mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_recyclerview_layout)

        var recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

//        val jobStoryObservable =
//                ApiClient.getApiServiceWithRx().getJobStories()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())

        mCompositeDisposable.add(ApiClient.getApiServiceWithRx().getJobStories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list ->
                            recyclerView.adapter = JobStoryAdapter(list)
                        }
                        , { e -> println("onError!") }
                        , { println("onComplete!") })
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable.clear()
    }
}