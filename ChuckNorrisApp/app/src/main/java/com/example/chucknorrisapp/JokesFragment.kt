package com.example.chucknorrisapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.chucknorrisapp.listagem.model.model.JokesModel
import com.example.chucknorrisapp.listagem.model.repository.JokesRepository
import com.example.chucknorrisapp.listagem.model.viewmodel.JokesViewModel
import com.squareup.picasso.Picasso

class JokesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoria = arguments?.getString("categoria")

        val viewModel = ViewModelProvider(
            this, JokesViewModel.JokesViewModelFactory(
                JokesRepository()
            )
        ).get(JokesViewModel::class.java)

        viewModel.getJokes(categoria!!).observe(viewLifecycleOwner) {
            mostrarResultados(it, view)
        }
    }

    fun mostrarResultados(it: JokesModel, view:View){
        val icone = view.findViewById<ImageView>(R.id.imageView)
        val mensagem = view.findViewById<TextView>(R.id.txtJoke)

        mensagem.text = it.joke
        Picasso.get()
            .load(it.icone)
            .into(icone)

    }

}