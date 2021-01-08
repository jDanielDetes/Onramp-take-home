package com.onramp.android.takehome.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.onramp.android.takehome.R

class MovieAdapter(private val movieList:List<movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    //extends the view holder
    class MovieViewHolder(movieView:View) : RecyclerView.ViewHolder(movieView){
        val imageView: ImageView = movieView.findViewById(R.id.image_view)
        val textview: TextView = movieView.findViewById(R.id.text_view)
        val button: Button = movieView.findViewById(R.id.button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieView= LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent, false)
        return MovieViewHolder(movieView)
    }

    override fun getItemCount() = movieList.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie= movieList[position]

        holder.imageView.setImageResource(currentMovie.image)
        holder.textview.text=currentMovie.movie_title

    }
}