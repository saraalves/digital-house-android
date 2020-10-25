package com.digitalhouse.fakeloginapp

import android.content.Intent
import android.hardware.camera2.TotalCaptureResult
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_welcome.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            val user = UserService.logIn(email, password)

            if (email.isEmpty()) {
                edtEmail.error = "Digite um e-mail"
            } else if (password.isEmpty()) {
                edtEmail.error = "Digite uma senha"
            } else {
                try {
                    if (UserService.logIn(email, password) == null) {
                        throw Exception("Email ou senha incorretos")
                    } else {
                        val intent = Intent(this@MainActivity, WelcomeActivity::class.java)
                        intent.putExtra("USER_NAME", user?.name)
                        startActivity(intent)
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}