package com.example.loginwithviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.loginwithviewpager.users.UserService
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_sign_up.*
import java.lang.Exception

class SignUpFragment : Fragment() {
    lateinit var minhaView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_sign_up, container, false)


        val checkBox = minhaView.findViewById<CheckBox>(R.id.checkbox)


        checkBox.setOnCheckedChangeListener { _, isChecked ->
            btnSignup.isEnabled = isChecked
        }

        val btnSignup = minhaView.findViewById<Button>(R.id.btnSignup)
        btnSignup.setOnClickListener {
            val username = minhaView.findViewById<TextInputLayout>(R.id.edtUsernameSignup)
            val password = minhaView.findViewById<TextInputLayout>(R.id.edtPasswordSignup)
            val confirmPassword = minhaView.findViewById<TextInputLayout>(R.id.edtRepetPasswordSignup)

            val usernameText = username.editText?.text.toString()
            val passwordText = password.editText?.text.toString()
            val confirmPasswordText = confirmPassword.editText?.text.toString()

            when {
                usernameText.isEmpty() -> {
                    username.error = "Preencha o campo username"
                }
                passwordText.isEmpty() -> {
                    password.error = "Preencha o campo password"
                }
                confirmPasswordText != passwordText -> {
                    confirmPassword.error = "As senhas não são iguais"
                }
                else -> {
                    try {
                        val user = UserService.logIn(usernameText, passwordText)
                        if (user != null) {
                            Toast.makeText(
                                minhaView.context,
                                "Login realizado com sucesso",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                minhaView.context,
                                "Username ou senha incorretos",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(minhaView.context, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        return minhaView
    }

    companion object {

        fun newInstance(username: String, password: String, confirmPassword: String) =
            SignUpFragment().apply {
                arguments = Bundle().apply {
                    putString("USERNAME", username)
                    putString("PASSWORD", password)
                    putString("CONFIRM_PASSWORD", confirmPassword)
                }
            }
    }
}