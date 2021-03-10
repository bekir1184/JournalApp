package com.example.journalapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class DayAdapter (val days: ArrayList<Day>): RecyclerView.Adapter<DayAdapter.DayViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayAdapter.DayViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.day_item,parent,false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayAdapter.DayViewHolder, position: Int) {
        holder.bindItem(days.get(position))

    }

    override fun getItemCount(): Int {
        return days.size
    }

    class DayViewHolder(itemView: View ):RecyclerView.ViewHolder(itemView){
        val contnetTextView:TextView=itemView.findViewById(R.id.content)
        val dateTextView:TextView=itemView.findViewById(R.id.date)

        fun bindItem(item:Day){
            contnetTextView.setText(item.content)
            dateTextView.setText(item.date)
        }
    }
}