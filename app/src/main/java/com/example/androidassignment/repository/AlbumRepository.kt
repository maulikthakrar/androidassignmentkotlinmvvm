package com.example.androidassignment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidassignment.retrofit.Api
import com.example.androidassignment.models.Album
import javax.inject.Inject

class AlbumRepository @Inject constructor(private val api: Api) {

    private val _albums = MutableLiveData<ArrayList<Album>>()
    val albums: LiveData<ArrayList<Album>>
    get()=_albums

    suspend fun getAlbums(){
        val result=api.getAlbum()
        if(result.isSuccessful && result.body()!=null){
            _albums.postValue(result.body())
        }
    }
}