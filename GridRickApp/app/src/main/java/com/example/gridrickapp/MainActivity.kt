package com.example.gridrickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)

        RickApi.getData(this, object : IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {

                val viewAdapter = RickGridAdapter(personagens)
                recyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = viewGridManager
                    adapter = viewAdapter
                }

            }
        })
    }
}