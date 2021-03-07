/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        //Primeras pruebas de modificación
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //se carga el unico layout establecido
        val text = getString(R.string.roll) //seleccionamos el texto que queremos que muestre el toast
        val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT) //lo mostramos con una duracion corta de tiempo

        val rollButton: Button = findViewById(R.id.roll_button) //usamos la funcion findview para usar el id establecido en el xml del boton
        rollButton.setOnClickListener {
            rollDice() //cuando se pulse el boton se ejecutara la funcion de cambio de imagen
            toast.show() //llamamos al metodo show para que lo muestre cada vez que tiremos del dado
        }

        //carga la primera imagen vacia
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.cero_estrellas_angra
            2 -> R.drawable.uno_estrellas_asterios
            3 -> R.drawable.dos_estrellas_andersen
            4 -> R.drawable.tres_estrellas_cu
            5 -> R.drawable.cuatro_estrellas_hessian_lobo
            else -> R.drawable.cinco_estrellas_tamamo
        } //elige imagenes de personajes en vez de los xml de dados de forma aleatoria

        diceImage.setImageResource(drawableResource)
        //muestra la imagen establecida por la funcion
    }
}
