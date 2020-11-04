package com.example.ciclodevida.contador.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ciclodevida.R
import com.example.ciclodevida.contador.viewmodel.ContadorViewModel
import com.example.ciclodevida.contador.viewmodel.ContadorViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var _viewModel: ContadorViewModel

    private val _texto by lazy { findViewById<TextView>(R.id.textView1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupUI()
    }

    private fun setupViewModel() {
        Log.i(TAG, "<--------- Inicio setupViewModel()")
        _viewModel = ViewModelProvider(
            this,
            ContadorViewModelFactory()
        ).get(ContadorViewModel::class.java)

        _viewModel.contador.observe(this, alterarTexto)

        Log.i(TAG, "<--------- Fim setupViewModel()")
    }

    private val alterarTexto = Observer<Int>{
        Log.i(TAG, "<--------- Alterou o texto")
        _texto.text = it.toString()
    }

    private fun setupUI() {
        findViewById<Button>(R.id.btnAdicionar).setOnClickListener{
            Log.i(TAG, "<--------- Cliquei no btnAdicionar()")
            _viewModel.incrementar()
        }
    }

    companion object{
        const val TAG = "MAIN_ACTIVITY"
    }


}