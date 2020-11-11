package com.example.simondice

import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object Corrutina {

    fun mostrar(array:ArrayList<Int>, rojo:ImageView,azul:ImageView,amarillo:ImageView,verde:ImageView){

//lanzamiento de la corrutina

        CoroutineScope(Dispatchers.Main).launch {

//metodo que recorre el array 1 y para cada color, lo muestra durante 0.750 segundos se pone en blanco durante 0.250 y pasa al siguiente

            for (color in array) {
                delay(250)
                when (color) {
                    1 -> {
                        rojo.setImageResource(R.drawable.red_square)
                        delay(750)
                        rojo.setImageResource(R.drawable.void_square)
                    }
                    2 -> {
                        azul.setImageResource(R.drawable.blue_square)
                        delay(750)
                        azul.setImageResource(R.drawable.void_square)
                    }
                    3 -> {
                        amarillo.setImageResource(R.drawable.yellow_square)
                        delay(750)
                        amarillo.setImageResource(R.drawable.void_square)
                    }
                    else -> {
                        verde.setImageResource(R.drawable.green_square)
                        delay(750)
                        verde.setImageResource(R.drawable.void_square)
                    }
                }
            }
        }
    }
}