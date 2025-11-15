package com.example.practicaimc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaimc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones(){
        enviarDatos()
    }

    private fun enviarDatos(){

        binding.btnEnviar.setOnClickListener {
            val altura = binding.altura.text.toString()
            val peso = binding.peso.text.toString()

            android.util.Log.d("MainActivity", "Botón pulsado: altura=$altura peso=$peso")

            if (altura.isNotEmpty() && peso.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("pesoIntroducido", peso)
                startActivity(intent)
            } else {
                Snackbar.make(it, "Faltan datos", Snackbar.LENGTH_SHORT).show()
            }
        }



    }


}