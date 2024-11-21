package com.example.flickr_code_challenge.data.remote.api

import com.example.flickr_code_challenge.data.remote.models.FlickrImageDTO
import com.example.flickr_code_challenge.data.remote.models.FlickrResponseDTO
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRequests {

    @GET("/services/feeds/photos_public.gne?format=json&nojsoncallback=1")
    suspend fun getImages(@Query("tags")tags:String): Response<FlickrResponseDTO>
}


object ApiServices{

    private const val BASE_URL = "https://api.flickr.com/"

    val api: ApiRequests by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiRequests::class.java)
    }
}