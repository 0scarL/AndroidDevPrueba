package com.e.androiddevloper.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.androiddevloper.Interface.PostListener
import com.e.androiddevloper.Model.response.PostDbResult
import com.e.androiddevloper.R

class FavoriteAdapter(var listaFavorite : List<PostDbResult>, var listener: PostListener ) :RecyclerView.Adapter<FavoriteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_details, parent, false)
        return FavoriteViewHolder(view)
    }

   override fun getItemCount(): Int {
       return listaFavorite.size

    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bin(listaFavorite[position], listener)
    }
}