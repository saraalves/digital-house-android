package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.R
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Exception

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnBackToLogin.setOnClickListener {
            finish()
        }

        checkboxPrivacyPolicy.setOnCheckedChangeListener { _, isChecked ->
            btnSignUp.isEnabled = isChecked
        }

        btnSignUp.setOnClickListener {
            val nome = edtNameSignUp.text.toString()
            val email = edtEmailSignUp.text.toString()
            val password = edtEmailSignUp.text.toString()

            when {
                nome.isEmpty() -> {
                    edtNameSignUp.error = "Campo vazio"
                }
                email.isEmpty() -> {
                    edtEmailSignUp.error = "Campo vazio"
                }
                password.isEmpty() -> {
                    edtPasswordSignUp.error = "Campo vazio"
                }
                else -> {
                    try {
                        UserService.register(nome, email, password)
                        Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show()
                        finish()
                    } catch (e: Exception){
                        Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }
}