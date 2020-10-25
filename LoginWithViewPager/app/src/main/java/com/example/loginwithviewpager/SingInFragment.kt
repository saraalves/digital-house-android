package com.example.loginwithviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.loginwithviewpager.users.UserService
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_sing_in.*
import java.lang.Exception

class SingInFragment : Fragment() {
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
        minhaView = inflater.inflate(R.layout.fragment_sing_in, container, false)

        loginUser()

        return minhaView
    }

    private fun loginUser() {
        val btnLogin = minhaView.findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val username = minhaView.findViewById<TextInputLayout>(R.id.edtUsername)
            val password = minhaView.findViewById<TextInputLayout>(R.id.edtPassword)

            val usernameText = username.editText?.text.toString()
            val passwordText = password.editText?.text.toString()
            when {
                usernameText.isEmpty() -> {
                    username.error = "Preencha o campo username"
                }
                passwordText.isEmpty() -> {
                    password.error = "Preencha o campo password"
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
    }

    companion object {

        @JvmStatic
        fun newInstance(username: String) =
            SingInFragment().apply {
                arguments = Bundle().apply {
                    putString("USERNAME", username)
                }
            }
    }
}