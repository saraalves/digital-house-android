package com.example.gridrickapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gridrickapp.api.IRespostaDaApi
import com.example.gridrickapp.api.Personagem
import com.example.gridrickapp.api.RickApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewGridManager = GridLayoutManager(this, 2)

        RickApi.getData(this, object : IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
//                criarLista(personagens)

                val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)
                val viewGridAdapter = RickGridAdapter(personagens) {
                    val intent = Intent(this@MainActivity, DetalheActivity::class.java)
                    intent.putExtra("Nome", it.nome)
                    intent.putExtra("Genero", it.genero)
                    intent.putExtra("Location", it.localizacao.nome)
                    intent.putExtra("Imagem", it.imagemUrl)
                    startActivity(intent)
                }

                recyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = viewGridManager
                    adapter = viewGridAdapter
                }
            }
        })
    }

//    fun criarLista(personagens: List<Personagem>) {
//        val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)
//        val viewGridManager = GridLayoutManager(this, 2)
//
//        var toast: Toast? = null
//
//        val viewAdapter = RickGridAdapter(personagens) {
//           val intent = Intent(this@MainActivity, DetalheActivity::class.java)
//        }
//
//        recyclerView.apply {
//            setHasFixedSize(true)
//            layoutManager = viewGridManager
//            adapter = viewAdapter
//        }
//    }

}