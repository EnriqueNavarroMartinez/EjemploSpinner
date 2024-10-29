package com.example.ejemplospinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
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

        val spCiudades:Spinner=findViewById<Spinner>(R.id.spinner)

        val ciudades=resources.getStringArray(R.array.ciudades)

        val adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item,ciudades)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spCiudades.adapter=adapter

        spCiudades.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val opcionSeleccionada = parent?.getItemAtPosition(position).toString()

                Toast.makeText(this@MainActivity,"Seleccionaste $opcionSeleccionada", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}