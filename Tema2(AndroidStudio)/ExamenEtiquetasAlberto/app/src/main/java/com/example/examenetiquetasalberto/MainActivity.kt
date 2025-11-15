package com.example.examen2alberto

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenetiquetasalberto.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()

    }

    fun acciones(){
        hibridoElectrico()
        siguientePagina()

    }

    fun hibridoElectrico(){

        if (binding.tipoGasolina.selectedItem.toString().equals("hibrido") || binding.tipoGasolina.selectedItem.toString().equals("electrico")) {

            binding.aOMatriculacion.isEnabled = false
            binding.aOMatriculacion.setText("2018")

        } else {
            binding.aOMatriculacion.isEnabled = true
        }

    }
    fun siguientePagina(){
        binding.btnSiguiente.setOnClickListener{
            val nombreApellidosTexto = binding.nombreApellido.text
            val matriculaTexto = binding.matricula.text
            val añoMatriculacionTexto = binding.aOMatriculacion.text
            val tipoGasolinaOpcion = binding.tipoGasolina.selectedItem
            val autonomiaTexto = binding.autonomia.text

            if (nombreApellidosTexto.isEmpty() || matriculaTexto.isEmpty()
                || añoMatriculacionTexto.isEmpty() || autonomiaTexto.isEmpty()){
                Snackbar.make(it,"Faltan datos", Snackbar.LENGTH_SHORT).show()
            }else{
                val intent: Intent =Intent(this,SecondActivity::class.java)
                intent.putExtra("nombre", binding.nombreApellido.text.toString())
                startActivity(intent)

            }
        }
    }



}