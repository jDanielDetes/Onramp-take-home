package com.onramp.android.takehome


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import com.bumptech.glide.Glide

import com.onramp.android.takehome.model.MovieAdapter
import kotlinx.android.synthetic.main.activity_movie_details.*



class movie_details() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)



        rate_movie_button.setOnClickListener {
            var dialog_frag = RatingFragment()

            dialog_frag.show(supportFragmentManager,"rating")
        }




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

        var reminderSet = true
        service_button.setOnClickListener {
            if (reminderSet) {
                MovieReminderService.startService(this, "Reminder to watch ${navtitle} ")
                reminderSet = false
                service_button.setText("Remove Reminder")
                service_button.setBackgroundColor(Color.RED)
            } else {
                MovieReminderService.stopService(this)
                reminderSet= true
                service_button.setText("Add Reminder")
                service_button.setBackgroundColor(Color.rgb(17,105,142))
            }
        }




    }

    }





