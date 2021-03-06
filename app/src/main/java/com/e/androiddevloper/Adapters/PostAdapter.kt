package com.e.androiddevloper.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.androiddevloper.Interface.PostListener
import com.e.androiddevloper.Model.response.PostDbResult
import com.e.androiddevloper.R

class PostAdapter(var context: Context, var listaPost: List<PostDbResult>, var listener: PostListener):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaPost.size
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bin(listaPost[position], listener, context)
    }
}