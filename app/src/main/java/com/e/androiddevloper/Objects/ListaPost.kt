package com.e.androiddevloper.Objects

import com.e.androiddevloper.Model.response.PostDbResult

object ListaPost {
    var listaPost : MutableList<PostDbResult> = mutableListOf()

    fun removePost(post: PostDbResult){
        listaPost.remove(post)
    }
}