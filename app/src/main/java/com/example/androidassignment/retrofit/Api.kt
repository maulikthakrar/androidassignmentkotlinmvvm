package com.example.androidassignment.retrofit

import com.example.androidassignment.models.Album
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("photos")
    suspend fun getAlbum(): Response<ArrayList<Album>>
}