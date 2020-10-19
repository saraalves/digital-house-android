package br.com.saraalves.meunome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnExibir.setOnClickListener {
            val nome = edtMeuNome.text

            txtNomeDigitado.text = nome
        }
    }
}