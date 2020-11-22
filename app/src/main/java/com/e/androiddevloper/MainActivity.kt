package com.e.androiddevloper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.e.androiddevloper.Adapters.TabsAdapter
import com.e.androiddevloper.Model.PostDbClient
import com.e.androiddevloper.Model.apis.PostDbService
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testDataFromPost()
        setTabs()

    }

    fun setTabs(){
        /**Luego de crear el TabAdapter, ahora lo seteo**/
        myViewPager.adapter = TabsAdapter(supportFragmentManager)
        /**configuro el viewPager y tabs**/
        myTabLayout.setupWithViewPager(this.myViewPager)
    }

    fun testDataFromPost() {
        doAsync {
            val call = PostDbClient.service()
                    .create(PostDbService::class.java)
                    .getPost()
                    .execute()
            uiThread {
                if (call.isSuccessful) {
                    Toast.makeText(it, "se cargaron los datos ", Toast.LENGTH_SHORT).show()
                    val llamado = call.body().toString()
                    Toast.makeText(it, "" + llamado, Toast.LENGTH_SHORT).show()

                }

            }
        }
    }

}