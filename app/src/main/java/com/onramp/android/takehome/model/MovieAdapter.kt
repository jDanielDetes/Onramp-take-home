package com.onramp.android.takehome.model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onramp.android.takehome.R
import com.onramp.android.takehome.movie_details

class MovieAdapter(private val movieList: List<movie>, private val mrow: Int) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    //extends the view holder
    class MovieViewHolder(val movieView: View, var movieData: movie? = null) : RecyclerView.ViewHolder(movieView) {
        val imageView: ImageView = movieView.findViewById(R.id.image_view)
        val textview: TextView = movieView.findViewById(R.id.text_view)

        companion object {
            val MOVIE_TITLE_KEY = " MOVIE_TITLE"
            val MOVIE_RELEASE_KEY = "MOVIE_RELEASE"
            val MOVIE_POSTER_KEY = "MOVIE_POSTER"
            val MOVIE_BACKDROP_KEY = "MOVIE_BACKDROP"
            val MOVIE_OVERVIEW_KEY = "MOVIE_OVERVIEW"
            val MOVIE_VOTE_KEY = "MOVIE_VOTE"
            val MOVIE_ID_KEY = "MOVIE_ID"
        }

        init {
            movieView.setOnClickListener {
                println("TEST")

                val intent = Intent(movieView.context, movie_details::class.java)

                intent.putExtra(MOVIE_TITLE_KEY, movieData?.original_title)
                intent.putExtra(MOVIE_RELEASE_KEY, movieData?.release_date)
                intent.putExtra(MOVIE_POSTER_KEY, movieData?.poster_path)
                intent.putExtra(MOVIE_BACKDROP_KEY, movieData?.poster_path)
                intent.putExtra(MOVIE_OVERVIEW_KEY, movieData?.overview)
                intent.putExtra(MOVIE_VOTE_KEY, movieData?.vote_average)
                intent.putExtra(MOVIE_ID_KEY, movieData?.id)

                movieView.context.startActivity(intent)


            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieView = LayoutInflater.from(parent.context).inflate(mrow, parent, false)
        return MovieViewHolder(movieView)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movieList[position]
        holder.textview?.text = currentMovie.original_title
        Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/w1280/" + currentMovie.poster_path)
                .into(holder.imageView)
        holder?.movieData = currentMovie
    }
}

