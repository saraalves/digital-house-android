package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

            if(nome.isEmpty() && email.isEmpty() && password.isEmpty()) {
                edtNameSignUp.error = "Campo vazio"
                edtEmailSignUp.error = "Campo vazio"
                edtPasswordSignUp.error = "Campo vazio"
            }
            try {
                UserService.register(nome, email, password)

            } catch (e: Exception){

            }

        }
    }
}