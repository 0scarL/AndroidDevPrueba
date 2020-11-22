package com.e.androiddevloper.Model.apis

import com.e.androiddevloper.Model.response.PostDbResult
import retrofit2.Call
import retrofit2.http.GET

interface PostDbService {

    @GET("posts")
    fun getPost(): Call<List<PostDbResult>>
}