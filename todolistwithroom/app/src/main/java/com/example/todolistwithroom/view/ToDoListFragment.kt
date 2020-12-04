package com.example.todolistwithroom.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistwithroom.R
import com.example.todolistwithroom.db.AppDatabase
import com.example.todolistwithroom.todolistroom.entity.ToDoListEntity
import com.example.todolistwithroom.todolistroom.repository.ToDoListRepository
import com.example.todolistwithroom.todolistroom.viewmodel.ToDoListViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ToDoListFragment : Fragment() {

    lateinit var _viewModel: ToDoListViewModel
    lateinit var _view: View
    private val _id = 0
    var toDoList = mutableListOf<ToDoListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        }
}