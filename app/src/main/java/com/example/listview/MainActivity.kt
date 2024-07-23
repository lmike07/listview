package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView: ListView = findViewById(R.id.lista)
        val ListaItems = arrayOf(
            "Ler um Livro",
            "Criar um projeto",
            "Aprender Kotlin",
            "Ter um tempo de descanso",
            "O Evangelho"
        )
        val listAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, ListaItems)
        listView.adapter = listAdapter
        
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(this,"Você clicou em: $selectedItem", Toast.LENGTH_SHORT).show()
        }

    }
}