package com.e.androiddevloper.Adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.e.androiddevloper.Ativities.DetailsActivity
import com.e.androiddevloper.Interface.PostListener
import com.e.androiddevloper.Objects.ListFavorite
import com.e.androiddevloper.Model.response.PostDbResult
import com.e.androiddevloper.Objects.ListaPost
import com.e.androiddevloper.Objects.PostDetail
import kotlinx.android.synthetic.main.layout_item_post.view.*

class PostViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    fun bin(post: PostDbResult, listener: PostListener, context: Context){
        itemView.layout_item_post_title.text = post.title
        itemView.layot_item_body.text = post.body
        itemView.layot_item_post_id.text = "Id: " + post.id.toString()
        /**funcionalidad si se hace longClick**/
        itemView.layot_item_body.setOnLongClickListener { itemView -> showAlert(itemView, post) }
        /**funcionalidad si se hace un click sobre la vista**/
        itemView.layot_item_body.setOnClickListener { View -> showDetails(View, post, listener, context) }
    }

    private fun showAlert(itemView: View, post: PostDbResult):Boolean{

        val builder = AlertDialog.Builder(itemView.context)
        builder.setTitle("Options")
        builder.setPositiveButton("Add to Favorite"){dialogInterface, i ->
            ListFavorite.addFavorite(post)
        }
        builder.setNegativeButton("Remove"){dialogInterface, i ->
            ListaPost.removePost(post)


            Log.d("lista", ListFavorite.listaFavorite.toString())
        }
        builder.create()
        builder.show()
        return true
    }
    private fun showDetails(itemView: View, post: PostDbResult, listener: PostListener, context: Context): Boolean{

        listener.goToOtherFragment()
        PostDetail.postDetails = post
        val intentDetalles : Intent = Intent(context,DetailsActivity::class.java)
        context.startActivity(intentDetalles)

        return true


    }
}