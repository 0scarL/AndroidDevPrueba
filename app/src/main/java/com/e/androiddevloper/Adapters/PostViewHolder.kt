package com.e.androiddevloper.Adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.e.androiddevloper.Model.response.PostDbResult
import kotlinx.android.synthetic.main.layout_item_details.view.*
import kotlinx.android.synthetic.main.layout_item_post.view.*

class PostViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    fun bin(post: PostDbResult){
        itemView.layout_item_post_title.text = post.title
        itemView.layot_item_body.text = post.body
        itemView.layot_item_post_id.text = "${"Id: "}${post.id.toString()}"

    }
}