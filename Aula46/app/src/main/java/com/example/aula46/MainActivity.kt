package com.example.aula46

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : AppCompatActivity() {

    data class Usuario(val nome: String, val idade: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Write a message to the database
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("usuario")

        myRef.setValue(Usuario("Sara", 25))

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val usuarioSalvo = dataSnapshot.getValue(Usuario::class.java)!!
                val i = 1
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}