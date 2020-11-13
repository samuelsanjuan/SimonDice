package com.example.simondice

import android.media.Image
import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object Corrutina {

    fun mostrar(array:ArrayList<Int>, simon:ImageView){

//lanzamiento de la corrutina

        CoroutineScope(Dispatchers.Main).launch {

//metodo que recorre el array 1 y para cada color, lo muestra durante 0.750 segundos se pone en blanco durante 0.250 y pasa al siguiente

            for (color in array) {
                delay(200)
                when (color) {
                    1 -> {
                        simon.setImageResource(R.drawable.red_square)
                    }
                    2 -> {
                        simon.setImageResource(R.drawable.blue_square)
                    }
                    3 -> {
                        simon.setImageResource(R.drawable.yellow_square)
                    }
                    else -> {
                        simon.setImageResource(R.drawable.green_square)
                    }
                }
                delay(500)
                simon.setImageResource(R.drawable.void_square)
            }
        }
    }
}