package com.onramp.android.takehome.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    private val BASE_URL= "https://api.themoviedb.org/3/movie/now_playing?api_key=69da287f8d942bd5ac2693404c94e0da&language=en-US&page=1"
    private var mRetrofit: Retrofit? = null

    val client: Retrofit
        // below checks for a instance of retrofit, it not present a new instance is created
        get(){
            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return this.mRetrofit!!
        }
}