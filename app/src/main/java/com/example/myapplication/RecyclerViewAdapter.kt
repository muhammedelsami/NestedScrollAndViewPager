package com.example.myapplication

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerAdapter(private val list : ArrayList<String>) : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        var userName : TextView

        init {
            userName = itemView.findViewById(R.id.text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_item, parent, false)
        val context : Context = parent.context.applicationContext
        return ViewHolder(view)


    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: MainRecyclerAdapter.ViewHolder, position: Int) {
        holder.userName.text = list[position]
        holder.itemView.setOnScrollChangeListener { view, i, i2, i3, i4 ->
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}