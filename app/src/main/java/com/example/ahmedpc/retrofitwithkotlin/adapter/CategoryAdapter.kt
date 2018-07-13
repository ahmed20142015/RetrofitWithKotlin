package com.example.ahmedpc.retrofitwithkotlin.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ahmedpc.retrofitwithkotlin.R
import com.example.ahmedpc.retrofitwithkotlin.ReadPdf
import com.example.ahmedpc.retrofitwithkotlin.model.Category
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryAdapter(val items: ArrayList<Category>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item, parent, false))

    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var category: Category = items[position]
        holder!!.category_name?.text = category.title
        holder!!.item = category
    }


}

class ViewHolder (view: View , var item:Category?=null) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each category to

    init {
        view.setOnClickListener {
          //  Toast.makeText(view.context,item!!.title,Toast.LENGTH_SHORT).show();

            var intent: Intent = Intent(view.context, ReadPdf::class.java)
            view.context.startActivity(intent!!)
        }
    }

    val category_name = view.category_name
}

