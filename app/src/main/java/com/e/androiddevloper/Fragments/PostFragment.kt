package com.e.androiddevloper.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.androiddevloper.Adapters.PostAdapter
import com.e.androiddevloper.Interface.PostListener
import com.e.androiddevloper.Model.PostDbClient
import com.e.androiddevloper.Model.apis.PostDbService
import com.e.androiddevloper.Model.response.PostDbResult
import com.e.androiddevloper.Objects.ListaPost
import com.e.androiddevloper.Objects.ListaPost.listaPost
import com.e.androiddevloper.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_post.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*


class PostFragment : Fragment(), PostListener {
    lateinit private var postAdapter: PostAdapter
    val TAB_DETAILS = 1
    var busqueda : String =""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let { setPostAdapter(it) }
        getFromPost()

        imageView_buscar.setOnClickListener {
            busqueda = editText_buscar.text.toString().toLowerCase()
            filtrar(busqueda, postAdapter)
            /**para renderizar esta nueva lista, que es la filtrada entonces uso el mismo adaptador de Productos**/

        }

    }

    fun setPostAdapter(context : Context){
        postAdapter = PostAdapter(context  ,listOf(),this )
        myRecyclerView.adapter = postAdapter
        myRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    /**Peticion de servicio y datos fuera del hilo principal de la App**/
    fun getFromPost() {
        doAsync {
            val call = PostDbClient.service()
                    .create(PostDbService::class.java)
                    .getPost()
                    .execute()
            uiThread {
                if (call.isSuccessful) {

                    /**aca tenemos el listado de Post**/
                    val listaHotPost = call.body() ?: listOf()
                    ListaPost.listaPost = listaHotPost as MutableList<PostDbResult>
                    //Toast.makeText(context, "data "+ listaPost , Toast.LENGTH_SHORT).show()
                    postAdapter.listaPost = listaPost
                    postAdapter.notifyDataSetChanged()

                }

            }
        }

    }

    override fun reloadPostView() {
        /**no requerido en esta clase**/
    }

    override fun goToOtherFragment() {
        activity?.myViewPager?.setCurrentItem(TAB_DETAILS)
    }

}

fun filtrar(busqueda: String, postAdapter: PostAdapter) {
    val listaFiltrada : MutableList<PostDbResult> = mutableListOf()
    for(item in ListaPost.listaPost){
        if(item.title.toLowerCase(Locale.ROOT).contains(busqueda)){
            listaFiltrada.add(item)
        }
    }
    postAdapter.listaPost = listaFiltrada
    postAdapter.notifyDataSetChanged()
}




