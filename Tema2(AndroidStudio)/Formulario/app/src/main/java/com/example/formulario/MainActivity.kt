package com.example.formulario

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.formulario.databinding.ActivityMainBinding
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.formulario.model.Usuario
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar
import kotlin.math.exp

class MainActivity : AppCompatActivity(),View.OnClickListener {

    //0 activar binding en modulo.
    //1. crear binding variable
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //2 inflar layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        //3 cambiar ruta a la de binding
        setContentView(binding.root)
        acciones()

    }

    private fun acciones(){
        binding.botonEnviar.setOnClickListener{
            val nombre = binding.editNombre.text.toString()
            val mail = binding.editEmail.text.toString()
            val pass = binding.editPass.text.toString()
            val localizacion = binding.editUbicaciones.text.toString()
            val experiencia = binding.chechExperiencia.isChecked
            val estudios = binding.spinnerPuesto.selectedItem
            lateinit var cantidad : String
            if (experiencia) {
                when (binding.radioGrupos.checkedRadioButtonId) {
                    binding.radioMenos5.id -> {
                        cantidad = "menos de 5"
                    }

                    binding.radioMas5.id -> {
                        cantidad = "mas de 5"
                    }

                }
            }else {
                cantidad = "sin experiencia"
            }
            if (nombre.isNotEmpty() && pass.isNotEmpty() && mail.isNotEmpty() && localizacion.isNotEmpty()){
                if (mail=="admin@admin.com" && pass=="admin"){
                    val intent = Intent(applicationContext, SecondActivity::class.java)
                    val usuario = Usuario(nombre,pass,mail,localizacion, estudios.toString(), cantidad)
                    intent.putExtra("correo", mail)
                    startActivity(intent)
                }else{
                    Snackbar.make(it,"Datos incorrectos",
                        Snackbar.LENGTH_SHORT).show()
                }
            }else{
                Snackbar.make(it,"Faltan datos",
                    Snackbar.LENGTH_SHORT).show()
                            }




        }
        
        binding.radioGrupos.setOnCheckedChangeListener { view, element ->
         when(element){
             binding.radioMenos5.id->{
                 Log.v("radios","seleccionado el de menos de 5")
             }
             binding.radioMas5.id->{
                 Log.v("radios","seleccionado el de mas de 5")
             }
         }
        }
        binding.spinnerPuesto.onItemClickListener
        binding.spinnerPuesto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.v("spinner",binding.spinnerPuesto.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}
