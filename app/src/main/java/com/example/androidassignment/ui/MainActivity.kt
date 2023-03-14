package com.example.androidassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassignment.adapters.AlbumAdapter
import com.example.androidassignment.databinding.ActivityMainBinding
import com.example.androidassignment.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
      //  binding.recyclerview.addItemDecoration(DividerItemDecoration(binding.recyclerview.context, (binding.recyclerview.layoutManager as LinearLayoutManager).orientation))
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.albumsLiveData.observe(this, Observer {
                if(it.size>0){
                    binding.progressBar.visibility=View.GONE
                    binding.recyclerview.visibility=View.VISIBLE
                    albumAdapter= AlbumAdapter(this@MainActivity,it)
                    binding.recyclerview.adapter = albumAdapter
                }else {
                    binding.progressBar.visibility=View.GONE
                    Toast.makeText(this@MainActivity, "No Album found !", Toast.LENGTH_LONG).show()
                }
        })
    }

    fun openAlbumDetails(title: String, url: String) {
        val intent = Intent(this@MainActivity, AlbumDetailsActivity::class.java)
        intent.putExtra("title", title)
        intent.putExtra("url", url)
        startActivity(intent)
    }
}