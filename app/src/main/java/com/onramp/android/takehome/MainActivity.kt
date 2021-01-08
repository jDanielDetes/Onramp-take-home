package com.onramp.android.takehome

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.onramp.android.takehome.model.MovieAdapter
import com.onramp.android.takehome.model.movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieList = placeholderList(100)

        recycle_view.adapter = MovieAdapter(movieList)
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.setHasFixedSize(true)
    }

        private fun placeholderList(size: Int):List<movie> {
            val list = ArrayList<movie>()

            for(i in 0 until size) {
                val drawable = when (i % 3) {
                    1->R.drawable.placeholder
                    else -> R.drawable.ic_launcher_background
                }

                val item = movie(drawable,"Title: $1","www.google.com")
                list += item
            }
            return list
        }



}