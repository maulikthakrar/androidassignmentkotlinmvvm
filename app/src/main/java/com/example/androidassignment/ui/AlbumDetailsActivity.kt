package com.example.androidassignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidassignment.databinding.AlbumDetailsBinding
import com.squareup.picasso.Picasso

class AlbumDetailsActivity : AppCompatActivity() {

    lateinit var binding: AlbumDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AlbumDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        val url = intent.getStringExtra("url")
        binding.tvtitle.text=title
        Picasso.get().load(url).into(binding.img)
    }
}