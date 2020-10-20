package br.com.saraalves.exerciciorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)
        val viewAdapter = MeuAdapter(arrayListOf(
            Conversa("Ada Lovelace", "ela foi uma das precursoras das ciências da computação", "18h43"),
            Conversa("Betty Snyder", "eram responsáveis pela configuração do ENIAC", "18h43"),
            Conversa("Marlyn Wescoff", "eram responsáveis pela configuração do ENIAC", "18h43")))

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

    }
}



