package com.example.practicaimc

import android.os.Bundle
import android.text.Editable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicaimc.databinding.ActivityMainBinding
import com.example.practicaimc.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    var pesoRecuperado : String? = null

    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pesoRecuperado = intent.getStringExtra("pesoIntroducido")

        binding.textpeso.text = pesoRecuperado




    }
}