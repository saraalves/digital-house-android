package br.com.saraalves.conversortemperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConverter.setOnClickListener {
            val temperaturaC = edtTemperatura.text.toString().toDouble()

            val temperaturaF = conversorTemperaturaF(temperaturaC)

            txtTemperaturaConvertida.text = temperaturaF.toString()
        }
    }

    fun conversorTemperaturaF(num: Double): Double {
        return ((num * 9) / 5) + 32
    }
}