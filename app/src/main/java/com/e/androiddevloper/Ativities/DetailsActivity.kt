package com.e.androiddevloper.Ativities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.androiddevloper.Objects.PostDetail
import com.e.androiddevloper.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        renderDetails()

    }

    fun renderDetails(){
        layout_item_details_title.text = PostDetail.postDetails?.title
        layout_item_details_body.text = PostDetail.postDetails?.body
        layout_item_details_id.text = "Id: "+PostDetail.postDetails?.id.toString()
        layout_item_details_userId.text = "User Id: "+ PostDetail.postDetails?.userId.toString()
    }
}