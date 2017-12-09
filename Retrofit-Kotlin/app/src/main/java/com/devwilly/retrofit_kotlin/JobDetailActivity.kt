package com.devwilly.retrofit_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.devwilly.retrofit_kotlin.adapter.JobDetailAdapter
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
        setContentView(R.layout.item_recyclerview_layout)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val jobListItem = mutableListOf<JobDetailModel>()

        recyclerView.layoutManager = LinearLayoutManager(this)

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
                                        jobListItem.add(jobModel)

                                        recyclerView.adapter = JobDetailAdapter(jobListItem)
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