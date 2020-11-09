package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var simon:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simon=findViewById(R.id.simon)

//declaracion de botones, arrays y el boolean de jugando

//array1=generado, array2=dado por el jugador

        var array1= ArrayList<Int>()
        var array2=ArrayList<Int>()

        val rojo: Button=findViewById(R.id.rojo)
        val azul: Button=findViewById(R.id.azul)
        val amarillo: Button=findViewById(R.id.amarillo)
        val verde: Button=findViewById(R.id.verde)
        val inicio: Button = findViewById(R.id.inicio)
        val siguienteRonda: Button=findViewById(R.id.siguienteRonda)

        var jugando=false

//instrucciones para el boton de inicio (cambiar "jugando" a true, borrar los arrays que pudieran estar molestando con cosas dentro, y añadir el primer color al array 1)

        inicio.setOnClickListener(){
            Toast.makeText(applicationContext,"Inicio",Toast.LENGTH_SHORT).show()
            array1.clear()
            array2.clear()
            jugando=true
            array1.add(Random.nextInt(4)+1)
            mostrar(array1)
        }

//instrucciones para el boton siguiente ronda(comprueba si el usuario esta jugando y que la secuencia de colores introducida por el jugador sea la adecuada, borra el array2, y da otro numero al array1)

        siguienteRonda.setOnClickListener(){
            if (jugando){
                if (array1==array2){
                    array2.clear()
                    array1.add(Random.nextInt(4)+1)
                    mostrar(array1)
                }else{
                    //Toast.makeText(applicationContext, "fallaste", Toast.LENGTH_SHORT).show()
                    jugando=false
                    simon.setImageResource(R.drawable.game_over)
                }
            }else{
                Toast.makeText(applicationContext,"No le has dado a iniciar",Toast.LENGTH_SHORT).show()
            }
        }

//asignamos los distintos colores a valores del 1 al 4 que meteremos en el array 2

        rojo.setOnClickListener(){
            añadir(array2,1)
        }
        azul.setOnClickListener(){
            añadir(array2,2)
        }
        amarillo.setOnClickListener(){
            añadir(array2,3)
        }
        verde.setOnClickListener(){
            añadir(array2,4)
        }
    }

//rojo=1   azul=2   amarillo=3   verde=4

    fun añadir(array: ArrayList<Int>, color:Int){
        array.add(color)
    }

//muestra el array 1 con toasts

    private fun mostrar(array:ArrayList<Int>) {

        for (color in array) {
            when (color) {
                1 -> {
                    Corrutina.dibujarColor(1,simon)
                }
                2 -> {
                    Corrutina.dibujarColor(2,simon)
                }
                3 -> {
                    Corrutina.dibujarColor(3,simon)
                }
                else -> {
                    Corrutina.dibujarColor(4,simon)
                }
            }
        }
    }
}