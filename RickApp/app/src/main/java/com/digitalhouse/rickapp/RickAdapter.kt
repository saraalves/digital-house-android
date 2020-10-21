package com.digitalhouse.rickapp

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem
import com.squareup.picasso.Picasso

class RickAdapter(private val dataSet: List<Personagem>) :
    RecyclerView.Adapter<RickAdapter.RickViewHolder>() {

    class RickViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imagem: ImageView = view.findViewById(R.id.imageView1)
        private val nome: TextView = view.findViewById(R.id.txtNome)
        private val txtLife: TextView = view.findViewById(R.id.txtLife)
        private val txtRaca: TextView = view.findViewById(R.id.txtRaca)
        private val txtLocation: TextView = view.findViewById(R.id.txtLocation)
        private val txtPlanet: TextView = view.findViewById(R.id.txtPlanet)

        fun bind(personagem: Personagem){

            loadImage(personagem)
            nome.text = personagem.nome
            txtLife.text = personagem.status
            txtRaca.text = personagem.especie
            txtLocation.text = personagem.localizacao.toString()
        }

        private fun loadImage (personagem: Personagem) {
            Picasso.get()
                .load(personagem.imagemUrl)
                .into(imagem)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickViewHolder {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RickViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}