package com.example.gridrickapp

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



        RickApi.getData(this, object : IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                criarLista(personagens  )

                }
        })
    }

    fun criarLista(personagens: List<Personagem>) {
        val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)
        val viewGridManager = GridLayoutManager(this, 2)

            val viewAdapter = RickGridAdapter(personagens) {
                Toast.makeText(this, it.nome, Toast.LENGTH_LONG).show()
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewGridManager
            adapter = viewAdapter
        }
    }

}