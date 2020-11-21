package com.example.chucknorrisapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapp.listagem.model.repository.CategoriesRepository
import com.example.chucknorrisapp.listagem.model.viewmodel.CategoriesViewModel
import com.example.chucknorrisapp.view.ListagemAdapter

class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navControl: NavController = Navigation.findNavController(view)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerList)
        val manager =LinearLayoutManager(view.context)
        val listaDeCategorias = mutableListOf<String>()
        val listaAdapter = ListagemAdapter(listaDeCategorias){
            val bundle = bundleOf("categoria" to it)
            navControl.navigate(R.id.action_catListFragment_to_jokeFragment, bundle)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            adapter = listaAdapter
            layoutManager = manager
        }

        val viewModel =ViewModelProvider(this,CategoriesViewModel.CategoriesViewModelFactory(
            CategoriesRepository()
        )).get(CategoriesViewModel::class.java)

        viewModel.obterLista().observe(viewLifecycleOwner) {
            listaDeCategorias.addAll(it)
            listaAdapter.notifyDataSetChanged()
        }

    }

}
