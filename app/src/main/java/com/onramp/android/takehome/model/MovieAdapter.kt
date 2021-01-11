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

class MovieAdapter(private val movieList:List<moveTest>, private val mrow: Int) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {



    //extends the view holder
    class MovieViewHolder(val movieView:View, var test: moveTest? = null) : RecyclerView.ViewHolder(movieView){
        val imageView: ImageView = movieView.findViewById(R.id.image_view)
        val textview: TextView = movieView.findViewById(R.id.text_view)
        val button: Button = movieView.findViewById(R.id.button)
        val textview2: TextView = movieView.findViewById(R.id.text_view2)

        companion object{
            val MOVIE_TITLE_KEY=" MOVIE_TITLE"
        }

        init {
            movieView.setOnClickListener {
                println("TEST")

                val intent= Intent(movieView.context,movie_details::class.java)

                intent.putExtra(MOVIE_TITLE_KEY, test?.original_title)
                movieView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieView= LayoutInflater.from(parent.context).inflate(mrow,parent, false)
        return MovieViewHolder(movieView)
    }

    override fun getItemCount() : Int = movieList.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie= movieList[position]

       // holder.imageView.setImageResource(currentMovie.image)
        holder.textview?.text=currentMovie.original_title
        holder.textview2?.text=currentMovie.release_date

        Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/w1280/" + currentMovie.poster_path)
                .into(holder.imageView)

            holder?.test= currentMovie
    }
}