package com.example.loginwithsharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Switch

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefs = getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)
        val prefsChecked = prefs.getBoolean(NOTIFICATION_PREFS, false)

        val checkBox = findViewById<CheckBox>(R.id.checkbox)

        checkBox.isChecked = prefsChecked
        // escreve o valor
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            val prefs = getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)
            prefs.edit().putBoolean(NOTIFICATION_PREFS, isChecked).apply()
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val APP_NAME = "Aula41_Prefs"
        const val NOTIFICATION_PREFS = "NOTIFICATION_PREFS"
    }

}


