@file:Suppress("DEPRECATION")

package com.e.androiddevloper.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.e.androiddevloper.Fragments.FavoriteFragment
import com.e.androiddevloper.Fragments.PostFragment

class TabsAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {
    val NUMERO_TABS = 2
    val TAB_POST = 0
    val TAB_FAVORITE = 1


    override fun getItem(position: Int): Fragment {
        when(position){
            TAB_POST -> return PostFragment()
            else -> return FavoriteFragment()
        }
    }

    override fun getCount(): Int {
        return NUMERO_TABS
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            TAB_POST -> return "Post"
            else -> return "Favorite Post"}
    }
}