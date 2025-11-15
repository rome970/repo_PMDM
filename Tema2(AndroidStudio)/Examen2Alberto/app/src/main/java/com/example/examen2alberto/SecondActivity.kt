package com.example.examen2alberto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen2alberto.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    private lateinit var nombreRecibido: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    fun acciones(){
        recogerDatos()
    }


    fun recogerDatos(){

       nombreRecibido =  intent.extras?.getString("nombre").toString();
        binding.recogernombreApellido.append(nombreRecibido)


    }



}