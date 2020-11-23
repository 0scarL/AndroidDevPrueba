package com.e.androiddevloper.Adapters

import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.e.androiddevloper.Interface.PostListener
import com.e.androiddevloper.Model.ListFavorite
import com.e.androiddevloper.Model.response.PostDbResult
import kotlinx.android.synthetic.main.layout_item_details.view.*

class FavoriteViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    fun bin(post: PostDbResult, listener: PostListener){
        itemView.layout_item_details_title.text = post.title
        itemView.layout_item_details_body.text = post.body
        itemView.layout_item_details_id.text = "Id: " + post.id.toString()
        itemView.layout_item_details_userId.text = "User Id: " + post.userId.toString()
        /**funcionalidad si se hace longClick**/
        itemView.layout_item_details_body.setOnLongClickListener { itemView -> showAlert(itemView, post, listener) }
    }

    private fun showAlert(itemView: View, post: PostDbResult, listener: PostListener):Boolean{
        val builder = AlertDialog.Builder(itemView.context)
        builder.setTitle("Options")
        builder.setPositiveButton("Remove from Favorites"){dialogInterface, i ->
            ListFavorite.removeFavorite(post)
            listener.reloadPostView()
            Log.d("lista", ListFavorite.listaFavorite.toString())
        }
        builder.setNegativeButton("Cancel", { _, _ ->  })
        builder.create()
        builder.show()
        return true
    }
}