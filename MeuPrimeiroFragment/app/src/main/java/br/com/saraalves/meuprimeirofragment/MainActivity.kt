package br.com.saraalves.meuprimeirofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager

        val primeiroFragment = PrimeiroFragment()
        val segundoFragment = SegundoFragment()

        btn1.setOnClickListener {
            val transaction =  manager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, primeiroFragment)
            transaction.commit()
        }
        btn2.setOnClickListener{
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, segundoFragment)
            transaction.commit()
        }
    }
}