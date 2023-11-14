package com.example.actividades

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio1 : AppCompatActivity() {



     var buttons = mutableListOf<Button>()
     var jugadorActual = "X"



     lateinit var resultadoTextView: TextView
     lateinit var botonReiniciarTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)


        resultadoTextView = findViewById(R.id.Resultado)
        botonReiniciarTextView = findViewById(R.id.botonReiniciar)




        buttons = mutableListOf(
            findViewById(R.id.boton0),
            findViewById(R.id.boton1),
            findViewById(R.id.boton2),
            findViewById(R.id.boton3),
            findViewById(R.id.boton4),
            findViewById(R.id.boton5),
            findViewById(R.id.boton6),
            findViewById(R.id.boton7),
            findViewById(R.id.boton8)
        )
        resultadoTextView.visibility = View.INVISIBLE
        botonReiniciarTextView.visibility = View.INVISIBLE

        buttons.forEach { button ->
            button.setOnClickListener{
                onButtonClick(button)
            }
        }




        val reiniciarButton: Button = findViewById(R.id.botonReiniciar)
        reiniciarButton.setOnClickListener {
           recreate()
        }
    }

        fun onButtonClick(clickedButton: Button) {
        if (clickedButton.text.isEmpty()) {

            clickedButton.text = jugadorActual

            if (verificarGanador()) {
                mostrarResultado()
            } else {

                if(jugadorActual=="X"){
                    jugadorActual="O"
                }else{
                    jugadorActual="X"
                }


                if (jugadorActual == "O") {
                    hacerMovimientoMaquina()
                }
            }
        }
    }


     fun hacerMovimientoMaquina() {
         val casillasVacias = buttons.filter { it.text.isEmpty() }
         if (casillasVacias.isNotEmpty()) {
             val botonAlAzar = casillasVacias.random()
             botonAlAzar.text = jugadorActual


             if (verificarGanador()) {
                 mostrarResultado()
             } else {

                 if(jugadorActual=="X"){
                     jugadorActual="O"
                 }else{
                     jugadorActual="X"
                 }
             }
         }
     }



     fun verificarGanador(): Boolean {


        if(verificarEmpate()){
            verEmpate()
            return false
        }



         for (i in 0 until 3){

             if(buttons[i * 3].text.isNotEmpty() && buttons[i * 3].text == buttons[i * 3 + 1].text && buttons[i * 3].text == buttons[i * 3 + 2].text)
                return true
         }

         for (i in 0 until 3){
             if(buttons [i].text.isNotEmpty() && buttons[i].text == buttons[i + 3].text && buttons[i].text == buttons[i + 6].text)
                 return true
         }

         if(buttons[0].text.isNotEmpty() && buttons[0].text == buttons[4].text && buttons[0].text == buttons[8].text){
             return true
         }

         if (buttons[2].text.isNotEmpty() && buttons[2].text == buttons[4].text && buttons[2].text == buttons[6].text)    {
             return true
         }
         return false
    }



     fun mostrarResultado() {

        if (jugadorActual == "X") {
            resultadoTextView.text = "Has ganado :)"
        } else {
            resultadoTextView.text = "Has perdido :("
        }
        resultadoTextView.visibility = View.VISIBLE
        botonReiniciarTextView.visibility = View.VISIBLE
         buttons.forEach { button ->
             button.isEnabled=false
         }
    }


    fun verificarEmpate():Boolean{
        return buttons.all { it.text.isNotEmpty() }
    }

    fun verEmpate() {
        resultadoTextView.text = "Has empatado :/"
        botonReiniciarTextView.visibility = View.VISIBLE
        resultadoTextView.visibility = View.VISIBLE

       buttons.forEach { button ->
           button.isEnabled=false
       }
    }
}





