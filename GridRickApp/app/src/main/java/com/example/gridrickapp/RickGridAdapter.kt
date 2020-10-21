package com.example.gridrickapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gridrickapp.api.Personagem
import com.squareup.picasso.Picasso


class RickGridAdapter(private val dataSet: List<Personagem>) :
    RecyclerView.Adapter<RickGridAdapter.RickViewHolder>() {

    class RickViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imagem: ImageView = view.findViewById(R.id.imageView1)
        private val nome: TextView = view.findViewById(R.id.txtName2)

        fun bind(personagem: Personagem){

            loadImage(personagem)
            nome.text = personagem.nome
        }

        private fun loadImage (personagem: Personagem) {
            Picasso.get()
                .load(personagem.imagemUrl)
                .into(imagem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)

        return RickViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: RickViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }


}