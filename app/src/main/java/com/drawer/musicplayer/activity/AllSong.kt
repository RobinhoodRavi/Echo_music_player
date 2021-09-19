package com.drawer.musicplayer.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar

import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.drawer.musicplayer.R
import com.drawer.musicplayer.fragment.SettingFragment
import com.drawer.musicplayer.fragment.AboutusFragment
import com.drawer.musicplayer.fragment.AllsongFragment
import com.drawer.musicplayer.fragment.FavouriteFragment
import com.google.android.material.navigation.NavigationView

class AllSong : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView

    var previousMenuItem:MenuItem?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_song)

        drawerLayout=findViewById(R.id.drawerLayout)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        toolbar=findViewById(R.id.toolbar)
        frameLayout=findViewById(R.id.frame)
        navigationView=findViewById(R.id.navigationView)
        setUpToolbar()

        openAllsong()


       val actionBarDrawerToggle=ActionBarDrawerToggle(
           this@AllSong,
           drawerLayout,
           R.string.open_drawer,
           R.string.close_drawer
       )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            if (previousMenuItem !=null){
                previousMenuItem?.isChecked=false
            }

            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it

        when(it.itemId){
            R.id.allSong ->{
               supportFragmentManager.beginTransaction()
                   .replace(R.id.frame, AllsongFragment())
                   .commit()

                supportActionBar?.title="All Songs"
                drawerLayout.closeDrawers()
            }
            R.id.favourites ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, FavouriteFragment())
                    .commit()

                supportActionBar?.title="Favourites"

                drawerLayout.closeDrawers()

            }
            R.id.setting ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, SettingFragment())
                    .commit()

                supportActionBar?.title="Setting"

                drawerLayout.closeDrawers()
            }
            R.id.aboutUs ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, AboutusFragment())
                    .commit()

                supportActionBar?.title="About Us"

                drawerLayout.closeDrawers()
            }
        }
            return@setNavigationItemSelectedListener true
        }
    }

    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="Melodious"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id =item.itemId
        if (id== android.R.id.home){

            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
    fun openAllsong(){
        val fragment= AllsongFragment()
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame,fragment)
        transaction.commit()
        supportActionBar?.title="All Song"
    }

    override fun onBackPressed() {
        val frag =supportFragmentManager.findFragmentById(R.id.frame)

        when(frag){
            !is AllsongFragment ->openAllsong()

            else->super.onBackPressed()
        }
    }
}