package com.example.gridrickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        var nome = intent.getStringExtra("Nome")
        var genero = intent.getStringExtra("Genero")
        var planeta = intent.getStringExtra("Location")
        var imagem = intent.getStringExtra("Imagem")

        Picasso.get().load(imagem).into(findViewById<ImageView>(R.id.imageView))

        findViewById<TextView>(R.id.txtName).text = nome
        findViewById<TextView>(R.id.txtGenero).text = genero
        findViewById<TextView>(R.id.txtPlaneta).text = planeta
    }
}