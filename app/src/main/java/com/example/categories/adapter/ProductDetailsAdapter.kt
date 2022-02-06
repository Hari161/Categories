package com.example.categories.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.categories.MainActivity
import com.example.categories.MainDetails
import com.example.categories.R
import com.example.categories.response.Product

class ProductDetailsAdapter(
    val list: List<Product>, val context: Context
) : RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemsdetail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
        Glide.with(context).load(list[position].imageUrl)
            .into(holder.image_iv)
        holder.click_RL.setOnClickListener {
            val intent = Intent(context, MainDetails::class.java)
            val extras = Bundle()
            extras.putString("imgTitle", list[position].title)
            extras.putString("imgUrl", list[position].imageUrl)
            extras.putString("price", list[position].price.toString())
            extras.putString("details", list[position].description)
            intent.putExtras(extras)
            context.startActivity(intent)
        }
        holder.price.text=list[position].price.toString()

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val title: TextView = itemView.findViewById(R.id.tittle_tv)
        val price: TextView = itemView.findViewById(R.id.price_tv)
        val image_iv: ImageView = itemView.findViewById(R.id.image_iv)
        val click_RL: CardView = itemView.findViewById(R.id.cardHeader)

    }

}