package com.example.simondice

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

object ViewModel {

    //mutable datas para los toast y para bloquear los botones
    val botonEnable= MutableLiveData<Boolean>()
    val textoToast=MutableLiveData<String>()
    val botonClickable= MutableLiveData<Boolean>()

    //array1=generado, array2=dado por el jugador
    val array1= ArrayList<Int>()
    val array2=ArrayList<Int>()

    //boolean para saber si el usuario esta en partida
    var jugando=false

    init {
        //boton enable es para el boton de inicio el boton clickable es para todos los demas
        botonEnable.value = true
        botonClickable.value = true
    }


//cambiar "jugando" a true, borrar los arrays que pudieran estar molestando con cosas dentro, añadir y mostrar el primer color del array 1

    fun inicio(simon: ImageView){
        //desactiva el boton de inicio
        botonEnable.value=false
        //pone el cuadro en blanco (dibuja ningun color)
        simon.setImageResource(R.drawable.void_square)
        //limpia los arrays
        array1.clear()
        array2.clear()
        //cambia jugando a true
        jugando=true
        //añade un nuevo numero al array1
        array1.add(Random.nextInt(4)+1)
        //muestra el array1
        corrutinaMostrar(array1,simon)
    }

//comprueba si el usuario esta jugando y que la secuencia de colores introducida por el jugador sea la adecuada, borra el array2, y añade y muestra otro numero al array1

    fun actualizar(simon:ImageView){
        //comprueba si el jugador le ha dado a iniciar y esta jugando
        if (jugando){
            //comprueba que los arrays sean iguales
            if (array1==array2){
                //limpia el array2
                array2.clear()
                //añade un color al array1
                array1.add(Random.nextInt(4)+1)
                //llama al metodo que muestra los colores
                corrutinaMostrar(array1,simon)
            }else{
                //cambia jugando a false, porque el jugador perdio
                jugando=false
                //pone el dibujo de game over
                simon.setImageResource(R.drawable.game_over)
                //toast que te da la puntuacion al perder
                textoToast.value=("tu puntuacion ha sido "+(array1.size-1))
                //desbloqua el boton de inicio
                botonEnable.value=true
            }
        }else{
            //toast que te informa de que tienes que darle a iniciar
            textoToast.value= "No le has dado a iniciar"
        }
    }

    //añade un numero del 1 al 4 al array2 (1=rojo 2=azul 3=amarillo 4=verde)
    fun añadirArray2(color: Int){
        array2.add(color)
    }

    //metodo con la corrutina que se encarga de enseñar los colores y bloquar todos los botones menos el de inicio
    fun corrutinaMostrar(array:ArrayList<Int>, simon:ImageView){

        //lanzamiento de la corrutina
        CoroutineScope(Dispatchers.Main).launch {

            //bloquea los botones
            botonClickable.value= false

            //for que recorre el array 1, para cada color, lo muestra durante 0.500 segundos se pone en blanco durante 0.200 y pasa al siguiente
            for (color in array) {
                delay(50)
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
                delay(150)
                simon.setImageResource(R.drawable.void_square)
            }
            //desbloquea los botones
            botonClickable.value=true
        }
    }
}