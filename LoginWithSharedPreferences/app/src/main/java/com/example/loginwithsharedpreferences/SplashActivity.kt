package com.example.loginwithsharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val prefs = getSharedPreferences(LoginActivity.APP_NAME, Context.MODE_PRIVATE)
        val prefsChecked = prefs.getBoolean(LoginActivity.NOTIFICATION_PREFS, false)

        val goToLogin = findViewById<TextView>(R.id.txtGotoLogin)

        if(prefsChecked) {
            goToLogin.setOnClickListener {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        } else {
            goToLogin.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    companion object {
        const val APP_NAME = "Aula41_Prefs"
        const val NOTIFICATION_PREFS = "NOTIFICATION_PREFS"
    }
}