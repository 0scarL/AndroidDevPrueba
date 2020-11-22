@file:Suppress("DEPRECATION")

package com.e.androiddevloper.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.e.androiddevloper.Fragments.DetailsFragment
import com.e.androiddevloper.Fragments.FavoriteFragment
import com.e.androiddevloper.Fragments.PostFragment

class TabsAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {
    val NUMERO_TABS = 3

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return PostFragment()
            1 -> return DetailsFragment()
            else -> return FavoriteFragment()
        }
    }

    override fun getCount(): Int {
        return NUMERO_TABS
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Post"
            1-> return "Details Information"
            else -> return "Favorite Post"}
    }
}