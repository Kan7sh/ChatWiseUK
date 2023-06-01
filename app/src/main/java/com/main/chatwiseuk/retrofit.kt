package com.main.chatwiseuk

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com"

interface images{
    @GET("/photos")
    fun getImages(): Call<List<ModelImages>>
}

object ImagesService{
    val newsInstance:images
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(images::class.java)
    }
}