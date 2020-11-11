package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    lateinit var gameOver:ImageView
    lateinit var rojo:ImageView
    lateinit var azul:ImageView
    lateinit var amarillo:ImageView
    lateinit var verde:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameOver=findViewById(R.id.gameOver)


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
            gameOver.setImageResource(R.drawable.void_square)
            array1.clear()
            array2.clear()
            jugando=true
            array1.add(Random.nextInt(4)+1)
            Corrutina.mostrar(array1,rojo=findViewById(R.id.simonRojo),azul=findViewById(R.id.simonAzul),amarillo=findViewById(R.id.simonAmarillo),verde=findViewById(R.id.simonVerde))
        }

//instrucciones para el boton siguiente ronda(comprueba si el usuario esta jugando y que la secuencia de colores introducida por el jugador sea la adecuada, borra el array2, y da otro numero al array1)

        siguienteRonda.setOnClickListener(){
            if (jugando){
                if (array1==array2){
                    array2.clear()
                    array1.add(Random.nextInt(4)+1)
                    Corrutina.mostrar(array1,rojo=findViewById(R.id.simonRojo),azul=findViewById(R.id.simonAzul),amarillo=findViewById(R.id.simonAmarillo),verde=findViewById(R.id.simonVerde))
                }else{
                    jugando=false
                    gameOver.setImageResource(R.drawable.game_over)
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
}