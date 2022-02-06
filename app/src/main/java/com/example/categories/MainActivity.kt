package com.example.categories

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val handler = Handler()
        handler.postDelayed({
            callCategoryActivity()
        }, 1000)
    }

    private fun callCategoryActivity() {
        val intent = Intent(this, Categories::class.java)
        startActivity(intent)
        finish()
    }
}