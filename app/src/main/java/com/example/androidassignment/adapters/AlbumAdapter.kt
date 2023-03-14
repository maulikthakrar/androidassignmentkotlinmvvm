package com.example.androidassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignment.databinding.AlbumItemBinding
import com.example.androidassignment.models.Album
import com.example.androidassignment.ui.MainActivity
import com.squareup.picasso.Picasso

class AlbumAdapter(val mainActivity: MainActivity, private val albumList: ArrayList<Album>) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AlbumViewHolder(AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = albumList.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) =
        holder.bind(mainActivity,albumList[position])

    fun addAlbum(list: ArrayList<Album>) {
        albumList.addAll(list)
    }

    class AlbumViewHolder(private val binding: AlbumItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mainActivity: MainActivity, album: Album) {
            binding.tvalbumid.setText("Album Id :"+album.albumId)
            binding.tvtitle.text = album.title
            Picasso.get().load(album.thumbnailUrl).into(binding.img)
            itemView.setOnClickListener {
                mainActivity.openAlbumDetails(album.title,album.url)
            }
        }
    }
}