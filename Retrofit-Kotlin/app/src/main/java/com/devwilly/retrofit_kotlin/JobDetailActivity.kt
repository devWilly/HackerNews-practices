package com.devwilly.retrofit_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.devwilly.retrofit_kotlin.api.ApiClient
import com.devwilly.retrofit_kotlin.model.JobDetailModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Willy on 28/11/2017.
 */
class JobDetailActivity : AppCompatActivity() {

    val mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_story_layout)

        val jobDetailText = findViewById<TextView>(R.id.story_text)
        val sb = StringBuffer()

        val jobStoryObservable =
                ApiClient.getApiServiceWithRx().getJobStories()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())

        jobStoryObservable.subscribe(
                { list ->
                    Observable.fromIterable(list)
                            .flatMap { jobId -> getJobDetail(jobId) }
                            .subscribe(
                                    { jobModel ->
                                        val by      = jobModel.by
                                        val id      = jobModel.id
                                        val score   = jobModel.score
                                        val text    = jobModel.text
                                        val time    = jobModel.time
                                        val title   = jobModel.title
                                        val type    = jobModel.type
                                        val url     = jobModel.url

                                        sb.append("=======================================").append('\n')
                                                .append(title).append('\n').append(id).append('\n').append(text).append('\n')

                                        jobDetailText.text = sb.toString()
                                    }
                                    , { e -> println("get job detail info error!!") }
                                    , { println("get job detail onComplete!!") }
                            )
                }
                , { e -> println("get job stories error!!") }
                , { println("onComplete!!") }
        )

    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable.clear()
    }

    fun getJobDetail(jobId: Int): Observable<JobDetailModel> {
        return ApiClient.getApiServiceWithRx().getJobDetail(jobId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}