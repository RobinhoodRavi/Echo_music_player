package com.drawer.musicplayer.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.drawer.musicplayer.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val time:Long=1000
        Handler().postDelayed(Runnable {
           val intent = Intent(this@MainActivity, AllSong::class.java)
            startActivity(intent)
            finish()
        },time)
    }
}