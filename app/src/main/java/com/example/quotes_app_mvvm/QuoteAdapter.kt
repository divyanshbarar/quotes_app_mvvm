package com.example.quotes_app_mvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class QuoteAdapter(val context:Context, val results:List<com.example.quotes_app_mvvm.models.Result>):Adapter<QuoteAdapter.ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
       val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ResultViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
       val result=results[position]
        holder.author.text=result.author
        holder.content.text=result.content
    }

    class ResultViewHolder(itemView: View): ViewHolder(itemView)
    {
        var author=itemView.findViewById<TextView>(R.id.author)
        var content=itemView.findViewById<TextView>(R.id.content)
    }

}