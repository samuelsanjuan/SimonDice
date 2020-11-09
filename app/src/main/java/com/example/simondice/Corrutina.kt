package com.example.simondice

import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object Corrutina {

    fun dibujarColor(color: Int, simon:ImageView){

        CoroutineScope(Dispatchers.Main).launch {

            val color = when (color) {

                1 -> R.drawable.red_square

                2 -> R.drawable.blue_square

                3 -> R.drawable.yellow_square

                else -> R.drawable.green_square
            }
            simon.setImageResource(color)
            delay(1000)
            simon.setImageResource(R.drawable.void_square)
        }
    }
}