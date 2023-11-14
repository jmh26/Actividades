package com.example.actividades

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)
    }

    fun iniciarNuevaActividad(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val textoIngresado = editText.text.toString()


        val intent = Intent(this, Ejercicio2_1::class.java)
        intent.putExtra("numero que hemos pasado", 10)
        intent.putExtra("texto que hemos pasado", textoIngresado)


        startActivity(intent)
    }
}
