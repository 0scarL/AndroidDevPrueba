package com.e.androiddevloper.Extention

import android.content.Context
import android.widget.Toast

fun Context.myToast(messaje : String){
    Toast.makeText(this, messaje, Toast.LENGTH_SHORT).show()
}
