package com.example.chucknorrisapp.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapp.R
import java.util.*

class ListagemViewHolder(private  val view: View): RecyclerView.ViewHolder(view) {
    private val txtCategoria = view.findViewById<TextView>(R.id.txtCategoria)

    fun bind(categoria: String){
        txtCategoria.text = categoria.capitalize()
    }
}

