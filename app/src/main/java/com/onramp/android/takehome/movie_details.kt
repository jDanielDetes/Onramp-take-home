package com.onramp.android.takehome

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.bumptech.glide.Glide

import com.onramp.android.takehome.model.MovieAdapter
import org.w3c.dom.Text


class movie_details() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)



            //Recieve intents
       val navtitle= intent.getStringExtra(MovieAdapter.MovieViewHolder.MOVIE_TITLE_KEY)
        supportActionBar?.title= navtitle //Assigns navbar with movie title
        val overview = intent.getStringExtra(MovieAdapter.MovieViewHolder.MOVIE_OVERVIEW_KEY)
        val movieId= intent.getIntExtra(MovieAdapter.MovieViewHolder.MOVIE_ID_KEY, -1)
        val movieDetailUrl= "https://api.themoviedb.org/3/movie/$movieId?api_key=69da287f8d942bd5ac2693404c94e0da&language=en-US\""
            println(movieDetailUrl)
        val release_date = intent.getStringExtra(MovieAdapter.MovieViewHolder.MOVIE_RELEASE_KEY)
        val movie_Poster =  intent.getStringExtra(MovieAdapter.MovieViewHolder.MOVIE_POSTER_KEY)
        val movie_backdrop = intent.getStringExtra(MovieAdapter.MovieViewHolder.MOVIE_BACKDROP_KEY)
        val rating = intent.getStringExtra(MovieAdapter.MovieViewHolder.MOVIE_VOTE_KEY)

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w1280/" + movie_backdrop)
                .into(findViewById(R.id.imageView2))


        val overView:TextView =findViewById(R.id.overview)
        val titleView:TextView =findViewById(R.id.Title)

        overView.text = overview
        titleView.text=navtitle






    }

    }





