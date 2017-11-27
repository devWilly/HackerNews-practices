package com.devwilly.retrofit_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
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
        setContentView(R.layout.item_story_layout)

        val jobTitle = findViewById<TextView>(R.id.story_text)
        val sb = StringBuffer()

//        val jobStoryObservable =
//                ApiClient.getApiServiceWithRx().getJobStories()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())

        mCompositeDisposable.add(ApiClient.getApiServiceWithRx().getJobStories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list ->
                            for (item in list) {
                                sb.append(item).append('\n')
                            }

                            jobTitle.text = sb.toString()
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