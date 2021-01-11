package com.onramp.android.takehome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onramp.android.takehome.model.MovieAdapter

class movie_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

       val navtitle= intent.getStringExtra(MovieAdapter.MovieViewHolder.MOVIE_TITLE_KEY)
        supportActionBar?.title= navtitle
    }
}