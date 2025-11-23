package com.example.assignment2_darshilkumar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private val items: List<String>,
    private val onClick: (String) -> Unit,
    private val onLongClick: (Int) -> Unit // Added
) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item

        holder.itemView.setOnClickListener { onClick(item) }

        holder.itemView.setOnLongClickListener {
            onLongClick(position) // Trigger the delete in Activity
            true
        }
    }

    override fun getItemCount() = items.size
}