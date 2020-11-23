package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declaracion de botones y de la imagen

        val simon=findViewById<ImageView>(R.id.simon)

        val rojo: Button=findViewById(R.id.rojo)
        val azul: Button=findViewById(R.id.azul)
        val amarillo: Button=findViewById(R.id.amarillo)
        val verde: Button=findViewById(R.id.verde)
        val inicio: Button = findViewById(R.id.inicio)
        val siguienteRonda: Button=findViewById(R.id.siguienteRonda)

        //observers para saber cuando hay que desabilitar los botones (cuando se estan mostrando)
        ViewModel.botonClickable.observe(this, Observer{ botonClickable->siguienteRonda.isClickable=botonClickable})
        ViewModel.botonClickable.observe(this, Observer{ botonClickable->rojo.isClickable=botonClickable})
        ViewModel.botonClickable.observe(this, Observer{ botonClickable->azul.isClickable=botonClickable})
        ViewModel.botonClickable.observe(this, Observer{ botonClickable->amarillo.isClickable=botonClickable})
        ViewModel.botonClickable.observe(this, Observer{ botonClickable->verde.isClickable=botonClickable})

        //observer para  cuando salten los toasts (al perder y cuando no le has dado a iniciar)
        ViewModel.textoToast.observe(this, Observer { textoToast-> val mensaje=textoToast
            Toast.makeText(applicationContext,mensaje,Toast.LENGTH_SHORT).show()})

        //observer para desactivar el boton de inicio
        ViewModel.botonEnable.observe(this, Observer { botonEnable->inicio.isEnabled=botonEnable })

        //lanza metodo de instrucciones para el boton de inicio
        inicio.setOnClickListener(){
            ViewModel.inicio(simon)
        }

        //lanza metodo con instrucciones para el boton siguiente ronda
        siguienteRonda.setOnClickListener(){
            ViewModel.actualizar(simon)
        }

        //asignamos los distintos botones a valores del 1 al 4 (rojo=1   azul=2   amarillo=3   verde=4)
        rojo.setOnClickListener(){
            ViewModel.añadirArray2(1)
        }
        azul.setOnClickListener(){
            ViewModel.añadirArray2(2)
        }
        amarillo.setOnClickListener(){
            ViewModel.añadirArray2(3)
        }
        verde.setOnClickListener(){
            ViewModel.añadirArray2(4)
        }
    }
}