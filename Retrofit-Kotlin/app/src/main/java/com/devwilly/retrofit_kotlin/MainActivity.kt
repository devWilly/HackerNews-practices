package com.devwilly.retrofit_kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.top_story_btn).setOnClickListener({ openActivityPage(TopStoriesActivity::class.java) })

        val bestStoryBtn: Button = findViewById(R.id.best_stories_btn)
        bestStoryBtn.setOnClickListener({ openActivityPage(BestStoriesActivity::class.java) })

        findViewById<Button>(R.id.story_detail_btn).setOnClickListener({ openActivityPage(StoriesDetailActivity::class.java) })

    }

    private fun openActivityPage(cls: Class<*>) {
        val intent = Intent()
        intent.setClass(this@MainActivity, cls)
        startActivity(intent)
    }
}