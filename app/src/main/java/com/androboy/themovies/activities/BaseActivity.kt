package com.androboy.themovies.activities

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.androboy.themovies.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*

abstract class BaseActivity() : AppCompatActivity() {

    fun showLongToast(msg:String)
    {
        Toast.makeText(this, msg , Toast.LENGTH_LONG).show()
    }
    fun showLongSnackBar(msg:String)
    {
        Snackbar.make(root_view , msg , Snackbar.LENGTH_LONG).show()
    }



}