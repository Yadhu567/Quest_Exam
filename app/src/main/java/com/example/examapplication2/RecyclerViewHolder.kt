package com.example.examapplication2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView1: TextView = itemView.findViewById(R.id.title)
    var textView2: TextView = itemView.findViewById(R.id.description)
    var textView3: TextView = itemView.findViewById(R.id.category)
}