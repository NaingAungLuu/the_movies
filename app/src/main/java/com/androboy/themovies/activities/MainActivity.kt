package com.androboy.themovies.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.androboy.themovies.R
import com.androboy.themovies.fragments.HomeFragment
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

    fun loadFragment(fragment: Fragment):Boolean
    {
        if(fragment != null)
        {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_view, fragment)
                .commit()
            return true
        }

        return false

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id)
        {
            R.id.mnu_home -> loadFragment(HomeFragment())
            R.id.mnu_search -> loadFragment(HomeFragment())
            R.id.mnu_coming_soon -> showLongSnackBar("Coming Soon")
            R.id.mnu_downloads -> showLongSnackBar("Downloads")
            R.id.mnu_more -> showLongSnackBar("More")
            else -> return false
        }
        return true

    }
}
