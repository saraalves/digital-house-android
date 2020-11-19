package com.turma05.kotlinrickapp.listagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turma05.kotlinrickapp.R
import com.turma05.kotlinrickapp.listagem.model.PersonagemModel
import com.turma05.kotlinrickapp.listagem.repository.PersonagemRepository
import com.turma05.kotlinrickapp.listagem.viewmodel.PersonagemViewModel
import kotlinx.android.synthetic.main.fragment_lista.*

class ListaFragment : Fragment() {
    lateinit var _viewModel: PersonagemViewModel
    lateinit var _view: View
    private lateinit var _listaAdapter: ListaAdapter

    private var page: Int = 1

    private var _listaDePersonagens = mutableListOf<PersonagemModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        val lista = view.findViewById<RecyclerView>(R.id.lista)
        val manager = LinearLayoutManager(view.context)

        _listaDePersonagens = mutableListOf<PersonagemModel>()
        _listaAdapter = ListaAdapter(_listaDePersonagens)

        lista.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _listaAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            PersonagemViewModel.PersonagemViewModelFactory(PersonagemRepository())
        ).get(PersonagemViewModel::class.java)

        _viewModel.obterLista().observe(viewLifecycleOwner) {
            exibirResultados(it)
        }

        showLoading(true)
        setScrollView()
        initSearch()
    }

    private fun exibirResultados(lista: List<PersonagemModel>?) {
        showLoading(false)

        lista?.isNotEmpty()?.let { notfound(it) }

//        _listaDePersonagens.clear()
        lista?.let { _listaDePersonagens.addAll(it) }

        _listaAdapter.notifyDataSetChanged()
    }

    private fun initSearch() {
        val searchView = _view.findViewById<SearchView>(R.id.searchView)

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                _viewModel.buscar(query).observe(viewLifecycleOwner) {
                    exibirResultados(it)
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    exibirResultados(_viewModel.listaAntiga())
                }

                return true
            }
        })
    }

    fun showLoading(isLoading: Boolean) {
        val viewLoading = _view.findViewById<View>(R.id.loading)

        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

    fun notfound(notfound: Boolean) {
        if (notfound) {
            _view.findViewById<View>(R.id.notfoundLayout).visibility = View.GONE
        } else {
            _view.findViewById<View>(R.id.notfoundLayout).visibility = View.VISIBLE
        }
    }

    private fun setScrollView() {
        lista.run {
            addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val target: LinearLayoutManager? = lista.layoutManager as LinearLayoutManager?

                    val totalItemCount: Int = target!!.itemCount

                    val lastVisible: Int = target.findLastVisibleItemPosition()

                    val lastItem: Boolean = lastVisible + 5 >= totalItemCount

                    if(totalItemCount > 0 && lastItem) {
                         page ++
                        _viewModel.obterLista(null, page).observe(viewLifecycleOwner) {
                            exibirResultados(it)
                        }
                    }
                }
            })
        }
    }
}