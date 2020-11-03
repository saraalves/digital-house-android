package com.example.loginwithviewpager

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_sign_up.*
import java.lang.Exception

class SignUpFragment : Fragment() {

    private lateinit var mudarTabListener: IMudarTab


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val txtEditUserName = view.findViewById<TextInputEditText>(R.id.edtUserNameSignup)

        view.findViewById<Button>(R.id.btnSignup).setOnClickListener {
            mudarTabListener.mudarTab(SIGN_UP_FRAGMENT)
            mudarTabListener.userNameAlterado(txtEditUserName.text.toString())
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mudarTabListener = context as IMudarTab
    }
}