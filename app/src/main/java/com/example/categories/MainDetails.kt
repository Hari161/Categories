package com.example.categories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main_details.*
import kotlinx.android.synthetic.main.itemsdetail.*
import kotlinx.android.synthetic.main.itemsdetail.image_iv

class MainDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_details)
        Glide.with(this).load(intent.getStringExtra("imgUrl").toString())
            .into(img1_iv)
        title_tv.text=intent.getStringExtra("imgTitle")
        price1_tv.text=intent.getStringExtra("price")
        details_tv.text=intent.getStringExtra("details")
        arrow_IV.setOnClickListener { finish() }
    }

}