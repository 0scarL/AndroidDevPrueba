package com.e.androiddevloper.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.e.androiddevloper.Adapters.FavoriteAdapter
import com.e.androiddevloper.Interface.PostListener
import com.e.androiddevloper.Objects.ListFavorite
import com.e.androiddevloper.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_favorite.view.*


class FavoriteFragment : Fragment(), PostListener {
    var favoriteAdapter : FavoriteAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteAdapter = FavoriteAdapter(ListFavorite.listaFavorite, this)
        view.myFavRecyclerView.adapter = favoriteAdapter
        view.myFavRecyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
    }

    /**metodo para refrescar la vista de los fragments**/
    @Suppress("DEPRECATION")
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        reloadPostView()
    }

    override fun reloadPostView() {
        favoriteAdapter?.listaFavorite = ListFavorite.listaFavorite
        favoriteAdapter?.notifyDataSetChanged()
    }

    override fun goToOtherFragment() {
        activity?.myViewPager?.setCurrentItem(1)
    }
}