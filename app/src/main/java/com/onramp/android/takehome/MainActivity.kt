package com.onramp.android.takehome


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.widget.Button

import androidx.recyclerview.widget.LinearLayoutManager

import com.onramp.android.takehome.model.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import com.onramp.android.takehome.model.movieList


class MainActivity : AppCompatActivity() {
    private var mApiService: ApiService? = null

    private var mAdapter: MovieAdapter? = null
    private var movies: MutableList<movie> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val click_me = findViewById<Button>(R.id.button1)


         mAdapter = com.onramp.android.takehome.model.MovieAdapter(movies,R.layout.movie_item)
        recycle_view.layoutManager = LinearLayoutManager(this)


         mApiService = RestClient.client.create(ApiService::class.java);
        recycle_view!!.adapter=mAdapter
        fetchMovieList()





    }



            private fun fetchMovieList(){
                val call = mApiService!!.fetchMovies("test")
                call.enqueue(object : Callback<movieList> {
                    override  fun onResponse(call: retrofit2.Call<movieList>, response: retrofit2.Response<movieList>){


                        Log.d(TAG,"check:" +response.body()!!.results!!.size)
                        val moviesRes= response.body()
                        if(moviesRes != null) {
                            movies.addAll(moviesRes.results!!)
                            mAdapter!!.notifyDataSetChanged()
                        }

                    }

                    override fun onFailure(call: retrofit2.Call<movieList>, t: Throwable) {
                        Log.e(TAG,"Error :" + t.localizedMessage)


                    }
                })
            }



            companion object{
                private val TAG = MainActivity::class.java.simpleName
            }

}