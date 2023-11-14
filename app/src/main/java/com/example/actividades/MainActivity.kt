package com.example.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun abrirEjercicio1(view: View) {
        try {
            val intent = Intent(this, Ejercicio1::class.java)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun abrirEjercicio2(view: View) {
        val intent = Intent(this, Ejercicio2::class.java)
        startActivity(intent)
    }
//    fun abrirEjercicio3(view: View) {
//        val intent = Intent(this, Ejercicio3::class.java)
//        startActivity(intent)
//    }
//    fun abrirEjercicio4(view: View) {
//        val intent = Intent(this, Ejercicio4::class.java)
//        startActivity(intent)
//    }

}