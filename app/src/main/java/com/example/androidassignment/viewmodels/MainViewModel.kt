package com.example.androidassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidassignment.models.Album
import com.example.androidassignment.repository.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val albumRepository: AlbumRepository) :
    ViewModel() {


    val albumsLiveData: LiveData<ArrayList<Album>>
        get() = albumRepository.albums

    init {
        viewModelScope.launch {
            delay(1000)
            albumRepository.getAlbums()
        }
    }
}