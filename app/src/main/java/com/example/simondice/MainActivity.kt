package com.example.simondice

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rojo: Button=findViewById(R.id.rojo)
        val azul: Button=findViewById(R.id.azul)
        val amarillo: Button=findViewById(R.id.amarillo)
        val verde: Button=findViewById(R.id.verde)


        val toast1=Toast.makeText(this, "fallaste", Toast.LENGTH_SHORT)
        val toast2=Toast.makeText(this, "aaaaa", Toast.LENGTH_SHORT)

        val inicio: Button = findViewById(R.id.inicio)
        inicio.setOnClickListener(){

            println("a")
            simonDice(rojo,azul,amarillo,verde,toast2)
            toast1.show()
        }
    }
}


    private fun pedirArray2(rojo:Button,azul:Button,amarillo:Button,verde:Button,contador:Int): ArrayList<Int> {

        var array2 = ArrayList<Int>()

        var jugador:Int=0

        rojo.setOnClickListener(){
            jugador=1
            print("rojo")
        }
        azul.setOnClickListener(){
            jugador=2
            print("azul")
        }
        amarillo.setOnClickListener(){
            jugador=3
            print("amarillo")
        }
        verde.setOnClickListener(){
            jugador=4
            print("verde")
        }


        var a: Int=contador
        while (a!=0) {
            a--
            array2.add(jugador)
            println(array2[0])
        }
        return array2
    }

    private fun mostrarArray1(array1: ArrayList<Int>): ArrayList<Int> {
        array1.add(Random.nextInt(4) + 1)

        for (contador in 0..(array1.size)-1){
            when (array1[contador]){
                1-> {
                    println("hola rojo")}
                4-> {
                    println("hola verde")}
                2-> {
                    println("hola azul")}
                3-> {
                    println("hola amarillo")}
                else->{
                    println("ninguno de esos colores salio")
                }

            }

        }
        return array1
    }

private fun simonDice(rojo: Button,azul: Button,amarillo: Button,verde: Button,toast: Toast) {
    var array1 = ArrayList<Int>()

    var contador=0
    toast.show()
    do {
        var array2 = ArrayList<Int>()
        contador++
        array1=mostrarArray1(array1)
        array2=pedirArray2(rojo,azul,amarillo,verde,contador)
        println("b")

    }while (array1==array2)
    println("c")


}


