package com.e.androiddevloper.Objects

import com.e.androiddevloper.Model.response.PostDbResult

object ListFavorite {

    var listaFavorite : MutableList<PostDbResult> = mutableListOf()

    fun addFavorite (post: PostDbResult) {
        
        if (listaFavorite.contains(post)) return
        else {
            listaFavorite.add(post)


        }
    }
    fun removeFavorite(post: PostDbResult){
        listaFavorite.remove(post)

   }
}

