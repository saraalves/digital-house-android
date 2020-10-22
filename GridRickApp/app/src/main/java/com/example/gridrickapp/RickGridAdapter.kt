package com.example.gridrickapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gridrickapp.api.Personagem


class RickGridAdapter(private val dataSet: List<Personagem>, private val listener: (Personagem) -> Unit):
    RecyclerView.Adapter<PersonagemViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonagemViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)

            return PersonagemViewHolder(view)
        }

        override fun getItemCount() = dataSet.size

        override fun onBindViewHolder(holder: PersonagemViewHolder, position: Int) {
            val item = dataSet[position]
            holder.bind(item)

            holder.itemView.setOnClickListener { listener(item) }
        }
    }