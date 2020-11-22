package com.e.androiddevloper.Model

import com.e.androiddevloper.Model.apis.PostDbService
import com.e.androiddevloper.Model.response.PostDbResult
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

/**retrofit instance**/
object PostDbClient {


    fun service() : Retrofit {
        val httpClient = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit

        }

}