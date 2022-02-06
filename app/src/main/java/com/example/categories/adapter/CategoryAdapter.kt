package com.example.categories.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.categories.R
import com.example.categories.response.Category
import kotlinx.android.synthetic.main.activity_categories.*

class CategoryAdapter(
    val list: List<Category>, val context : Context
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitemcategory, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.catrgory_Name.text = list[position].title

        holder.click_RL.setOnClickListener {
            holder.arrowOrientazion.isSelected = !holder.arrowOrientazion.isSelected
            holder.rcview2.layoutManager= GridLayoutManager(context, 2)
            if(list[position].products !=null) {
                if(holder.hScrollview.visibility==View.GONE)
                    holder.hScrollview.visibility=View.VISIBLE
                else
                    holder.hScrollview.visibility=View.GONE
                val adapter = ProductDetailsAdapter(list[position].products, context)
                holder.rcview2.adapter = adapter
                holder.rcview2.adapter?.notifyDataSetChanged()
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val catrgory_Name: TextView = itemView.findViewById(R.id.categoryName_TV)
        val arrowOrientazion: TextView = itemView.findViewById(R.id.rightarrow_tv)
        val click_RL: RelativeLayout = itemView.findViewById(R.id.list_rl)
        val rcview2: RecyclerView = itemView.findViewById(R.id.rcview2)
        val hScrollview: HorizontalScrollView = itemView.findViewById(R.id.hScrollview)

    }

}