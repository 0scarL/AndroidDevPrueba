package com.e.androiddevloper.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.androiddevloper.Adapters.PostAdapter
import com.e.androiddevloper.Model.PostDbClient
import com.e.androiddevloper.Model.apis.PostDbService
import com.e.androiddevloper.Model.response.PostDbResult
import com.e.androiddevloper.R
import kotlinx.android.synthetic.main.fragment_post.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class PostFragment : Fragment() {
     lateinit private var postAdapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPostAdapter()
        getFromPost()

    }

    fun setPostAdapter(){
        postAdapter = PostAdapter(listOf())
        myRecyclerView.adapter = postAdapter
        myRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }


    fun getFromPost() {
        doAsync {
            val call = PostDbClient.service()
                    .create(PostDbService::class.java)
                    .getPost()
                    .execute()
            uiThread {
                if (call.isSuccessful) {

                    /**aca tenemos el listado de Post**/
                    val listaPost = call.body() ?: listOf()
                    //Toast.makeText(context, "data "+ listaPost , Toast.LENGTH_SHORT).show()
                    postAdapter.listaPost = listaPost
                    postAdapter.notifyDataSetChanged()

                }

            }
        }

    }




}