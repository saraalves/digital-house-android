package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            intent.putExtra("EMAIL", "Sara")
            intent.putExtra("PASSWORD", "1234")
            startActivity(intent)
        }
    }
}