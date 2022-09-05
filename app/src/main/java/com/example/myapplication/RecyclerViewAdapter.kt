package com.example.myapplication

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerAdapter(private val list: ArrayList<String>) :
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var city: TextView

        init {
            city = itemView.findViewById(R.id.text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.city.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
