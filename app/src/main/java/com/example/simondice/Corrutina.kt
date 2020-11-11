package com.example.simondice

import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object Corrutina {

    fun mostrar(array:ArrayList<Int>, rojo:ImageView,azul:ImageView,amarillo:ImageView,verde:ImageView){

        CoroutineScope(Dispatchers.Main).launch {

            for (color in array) {
                when (color) {
                    1 -> {
                        Corrutina.dibujarColor(1, rojo)
                        delay(1200)
                        rojo.setImageResource(R.drawable.void_square)
                    }
                    2 -> {
                        Corrutina.dibujarColor(2, azul)
                        delay(1200)
                        azul.setImageResource(R.drawable.void_square)
                    }
                    3 -> {
                        Corrutina.dibujarColor(3, amarillo)
                        delay(1200)
                        amarillo.setImageResource(R.drawable.void_square)
                    }
                    else -> {
                        Corrutina.dibujarColor(4, verde)
                        delay(1200)
                        verde.setImageResource(R.drawable.void_square)
                    }
                }
            }


        }
    }
    fun dibujarColor(color: Int,simon: ImageView){
    val color = when (color) {

        1 -> R.drawable.red_square

        2 -> R.drawable.blue_square

        3 -> R.drawable.yellow_square

        else -> R.drawable.green_square
    }
    simon.setImageResource(color)
    }
}