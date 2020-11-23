package com.e.androiddevloper.Adapters

import android.content.DialogInterface
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.e.androiddevloper.Interface.PostListener
import com.e.androiddevloper.Model.ListFavorite
import com.e.androiddevloper.Model.response.PostDbResult
import kotlinx.android.synthetic.main.layout_item_details.view.*
import kotlinx.android.synthetic.main.layout_item_post.view.*

class PostViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    fun bin(post: PostDbResult){
        itemView.layout_item_post_title.text = post.title
        itemView.layot_item_body.text = post.body
        itemView.layot_item_post_id.text = "Id: " + post.id.toString()
        /**funcionalidad si se hace longClick**/
        itemView.layot_item_body.setOnLongClickListener { itemView -> showAlert(itemView, post) }
    }

    private fun showAlert(itemView: View, post: PostDbResult):Boolean{

        val builder = AlertDialog.Builder(itemView.context)
        builder.setTitle("Options")
        builder.setPositiveButton("Add to Favorite"){dialogInterface, i ->
            ListFavorite.addFavorite(post)

            Log.d("lista",ListFavorite.listaFavorite.toString())
        }
        builder.setNegativeButton("Cancel", { _, _ ->  })
        builder.create()
        builder.show()
        return true
    }
}