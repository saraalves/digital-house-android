package com.example.chucknorrisapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapp.R

class ListagemAdapter(
    private val dataSet: List<String>,
    private val listener: (String) -> Unit) : RecyclerView.Adapter<ListagemViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListagemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)

        return ListagemViewHolder(view)
    }

    override fun getItemCount() = dataSet.size


    override fun onBindViewHolder(holder: ListagemViewHolder, position: Int) {
        val item = dataSet[position]

        holder.bind(item)

        holder.itemView.setOnClickListener { listener(item) }
    }

}