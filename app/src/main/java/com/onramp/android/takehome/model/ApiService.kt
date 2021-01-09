package com.onramp.android.takehome.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/3/movie/popular?api_key=69da287f8d942bd5ac2693404c94e0da&language=en-US&page=1")
    fun fetchMovies(@Query("")tags:String) : Call<movieList>
}