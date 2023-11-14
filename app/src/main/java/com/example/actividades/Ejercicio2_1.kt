package com.example.actividades


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2_1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2_1)

        val numero = intent.getIntExtra("numero", 0)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Número: $numero"
    }
}
