package br.com.saraalves.calculosalario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            val horasTrabalhadas = edtHorasTrabalhadas.text.toString().toDouble()
            val valorDaHora = edtValorDaHora.text.toString().toDouble()

            val result = calcularSalario(valorDaHora, horasTrabalhadas)

            txtResult.text = result.toString()
        }
    }

    fun calcularSalario(horasTrab: Double, valorDaHora: Double): Double {
        return valorDaHora * horasTrab
    }

}