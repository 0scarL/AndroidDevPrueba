package com.e.androiddevloper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.androiddevloper.Adapters.TabsAdapter
import com.e.androiddevloper.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTabs()

    }

    fun setTabs(){
        /**Luego de crear el TabAdapter, ahora lo seteo**/
        myViewPager.adapter = TabsAdapter(supportFragmentManager)
        /**configuro el viewPager y tabs**/
        myTabLayout.setupWithViewPager(this.myViewPager)
    }
}