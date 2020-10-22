package com.example.gridrickapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gridrickapp.api.Personagem
import com.squareup.picasso.Picasso

class PersonagemViewHolder (private val view: View): RecyclerView.ViewHolder(view) {
    private val imagem: ImageView = view.findViewById(R.id.imageView1)
    private val nome: TextView = view.findViewById(R.id.txtName2)

    fun bind (personagem: Personagem) {
        nome.text = personagem.nome

        Picasso.get()
            .load(personagem.imagemUrl)
            .into(imagem)
    }
}