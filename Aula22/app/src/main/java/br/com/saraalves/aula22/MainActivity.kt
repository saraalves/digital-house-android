package br.com.saraalves.aula22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val viewManager = LinearLayoutManager(this)
        val viewManager = GridLayoutManager(this, 2)
        val recyckerView = findViewById<RecyclerView>(R.id.minhaLista)
        val viewAdapter = MeuAdapter(arrayListOf("Laranja", "Morango", "Sorvete", "Xuxu", "Abobrinha", "Pessego"))

        recyckerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

//            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
//            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))

        }
    }
}