package com.androboy.themovies.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.androboy.themovies.R
import com.androboy.themovies.fragments.HomeFragment
import com.androboy.themovies.fragments.MovieDetailFragment
import com.androboy.themovies.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : BaseActivity() , BottomNavigationView.OnNavigationItemSelectedListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_home)
        setSupportActionBar(tbHome)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        bottomNavBar.isItemHorizontalTranslationEnabled = false
        bottomNavBar.setOnNavigationItemSelectedListener(this)
        loadFragment(HomeFragment())


    }

    fun loadFragment(fragment: Fragment)
    {
        if(fragment != null && fragment !is HomeFragment)
        {
            supportFragmentManager
                .beginTransaction()
                .addToBackStack("${fragment.id}")
                .replace(R.id.fragment_view, fragment)
                .commit()
        }
        else if(fragment != null && fragment is HomeFragment)
        {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_view, fragment)
                .commit()
        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id)
        {
            R.id.mnu_home -> loadFragment(HomeFragment())
            R.id.mnu_search -> loadFragment(SearchFragment())
            R.id.mnu_coming_soon -> showLongSnackBar("Coming Soon")
            R.id.mnu_downloads -> showLongSnackBar("Downloads")
            R.id.mnu_more -> showLongSnackBar("More")
            else -> return false
        }
        return true

    }

    fun playVideo()
    {
        startActivity(Intent(applicationContext , VideoPlayerActivity::class.java))
    }

}
