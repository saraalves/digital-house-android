package br.com.saraalves.anonascimento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class AnoNascimentoActivity : AppCompatActivity() {
    lateinit var manager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ano_nascimento)

        manager = supportFragmentManager

        val fragmentA = AFragment()
        val fragmentB = BFragment()

        val transaction1 = manager.beginTransaction()
        transaction1.replace(R.id.container1, fragmentA)
        transaction1.commit()

        val transaction2 = manager.beginTransaction()
        transaction2.replace(R.id.container2, fragmentB)
        transaction2.commit()

    }
}