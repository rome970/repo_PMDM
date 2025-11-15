package com.example.calculadora

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

class MainActivity : AppCompatActivity() {

    var numeroActual: Double = 0.0
    var numeroAnterior: Double = 0.0
    var numeroNuevo: Boolean = true
    var operacion: String = ""
    var resultado: String = ""

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState != null) {
            numeroActual = savedInstanceState.getDouble("numeroActual")
            numeroAnterior = savedInstanceState.getDouble("numeroAnterior")
            numeroNuevo = savedInstanceState.getBoolean("numeroNuevo")
            operacion = savedInstanceState.getString("operacion", "")
            resultado = savedInstanceState.getString("resultado", "")

            binding.textViewContador.text =
                if (resultado.isNotEmpty()) resultado else numeroActual.toString()
        }

        acciones()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("numeroActual", numeroActual)
        outState.putDouble("numeroAnterior", numeroAnterior)
        outState.putBoolean("numeroNuevo", numeroNuevo)
        outState.putString("operacion", operacion)
        outState.putString("resultado", binding.textViewContador.text.toString())
    }

    private fun acciones() {
        botones()
        suma()
        resta()
        multiplicacion()
        division()
        botonesCientifica()
        raiz()
    }

    private fun suma() {
        binding.btnSuma?.setOnClickListener {
            numeroAnterior = binding.textViewContador?.text.toString().toDouble()
            operacion = "+"
            numeroNuevo = true
        }
    }

    private fun resta() {
        binding.btnResta?.setOnClickListener {
            numeroAnterior = binding.textViewContador?.text.toString().toDouble()
            operacion = "-"
            numeroNuevo = true
        }
    }

    private fun multiplicacion() {
        binding.btnMultiplicar?.setOnClickListener {
            numeroAnterior = binding.textViewContador?.text.toString().toDouble()
            operacion = "*"
            numeroNuevo = true
        }
    }

    private fun division() {
        binding.btnDividir?.setOnClickListener {
            numeroAnterior = binding.textViewContador?.text.toString().toDouble()
            operacion = "/"
            numeroNuevo = true
        }
    }
    private fun raiz(){
        binding.btnRaiz?.setOnClickListener {
            val texto = binding.textViewContador?.text.toString()
            val valor = texto.toDoubleOrNull()

            if (valor == null) {
                Toast.makeText(this, "Por favor, introduzca un valor válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (valor < 0) {
                Toast.makeText(this, "No se puede sacar raíz negativa", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            numeroActual = sqrt(valor)
            binding.textViewContador?.setText(numeroActual.toString())
            numeroNuevo = true
        }

    }

    private fun cambiarSigno() {
        if (binding.textViewContador?.text.toString() == "0") {
            Toast.makeText(this, "Por favor, introduzca un valor válido", Toast.LENGTH_SHORT)
                .show() // Hecho con Toas porque Snackbar me daba error.
        } else {
            numeroActual = binding.textViewContador?.text.toString().toDouble() * -1.0
            binding.textViewContador?.setText(numeroActual.toString())
        }
    }

    private fun agregarDigitos(digito: String) {
        if (numeroNuevo) {
            binding.textViewContador?.setText(digito)
            numeroNuevo = false
        } else {
            binding.textViewContador?.append(digito)
        }
    }

    private fun botonesCientifica() {

        binding.btnSIN?.setOnClickListener {
            val texto = binding.textViewContador?.text.toString()
            val valor = texto.toDoubleOrNull()

            if (valor == null) {
                binding.textViewContador?.setText("Error")
                numeroNuevo = true
                return@setOnClickListener
            }

            val anguloRad = Math.toRadians(valor)
            val resultadoSin = sin(anguloRad)

            binding.textViewContador?.setText(resultadoSin.toString())
            numeroActual = resultadoSin
            numeroNuevo = true
            numeroAnterior = numeroActual
        }

        binding.btnCOS?.setOnClickListener {
            val texto = binding.textViewContador?.text.toString()
            val valor = texto.toDoubleOrNull()

            if (valor == null) {
                binding.textViewContador?.setText("Error")
                numeroNuevo = true
                return@setOnClickListener
            }

            val anguloRad = Math.toRadians(valor)
            val resultadoCos = cos(anguloRad)

            binding.textViewContador?.setText(resultadoCos.toString())
            numeroActual = resultadoCos
            numeroNuevo = true
            numeroAnterior = numeroActual
        }

        binding.btnTAN?.setOnClickListener {
            val texto = binding.textViewContador?.text.toString()
            val valor = texto.toDoubleOrNull()

            if (valor == null) {
                binding.textViewContador?.setText("Error")
                numeroNuevo = true
                return@setOnClickListener
            }

            val anguloRad = Math.toRadians(valor)
            val coseno = cos(anguloRad)

            if (coseno == 0.0) {
                binding.textViewContador?.setText("Error")
                numeroNuevo = true
                return@setOnClickListener
            }

            val resultadoTan = tan(anguloRad)
            binding.textViewContador?.setText(resultadoTan.toString())
            numeroActual = resultadoTan
            numeroNuevo = true
            numeroAnterior = numeroActual
        }

    }



        fun botones() {

            binding.btn0?.setOnClickListener { agregarDigitos("0") }
            binding.btn1?.setOnClickListener { agregarDigitos("1") }
            binding.btn2?.setOnClickListener { agregarDigitos("2") }
            binding.btn3?.setOnClickListener { agregarDigitos("3") }
            binding.btn4?.setOnClickListener { agregarDigitos("4") }
            binding.btn5?.setOnClickListener { agregarDigitos("5") }
            binding.btn6?.setOnClickListener { agregarDigitos("6") }
            binding.btn7?.setOnClickListener { agregarDigitos("7") }
            binding.btn8?.setOnClickListener { agregarDigitos("8") }
            binding.btn9?.setOnClickListener { agregarDigitos("9") }

            binding.btnPorcentaje?.setOnClickListener {
                val valor = binding.textViewContador?.text.toString().toDoubleOrNull()
                if (valor == null) {
                    binding.textViewContador?.setText("Error")
                    numeroNuevo = true
                    return@setOnClickListener
                }

                numeroActual = valor / 100
                binding.textViewContador?.setText(numeroActual.toString())
                numeroNuevo = true
            }


            binding.btnComa?.setOnClickListener {
                val texto = binding.textViewContador?.text.toString()

                if (numeroNuevo) {
                    binding.textViewContador?.setText("0.")
                    numeroNuevo = false
                } else if (texto.contains(".")) {
                    Snackbar.make(it, "Coma ya introducida", Snackbar.LENGTH_LONG).show()
                } else {
                    binding.textViewContador?.append(".")
                }
            }


            binding.btnSigno?.setOnClickListener { cambiarSigno() }

            binding.btnAC?.setOnClickListener {
                binding.textViewContador?.setText("0")
                numeroNuevo = true
                numeroAnterior = 0.0
                numeroActual = 0.0
                operacion = ""
            }

            binding.btnIgual?.setOnClickListener {
                if (binding.textViewContador!!.text.isEmpty()) {
                    Snackbar.make(it, "Porfavor introduzca un valor", Snackbar.LENGTH_LONG).show()
                    return@setOnClickListener
                } else {
                    numeroActual = binding.textViewContador?.text.toString().toDouble()
                    val valor = when (operacion) {
                        "+" -> numeroAnterior + numeroActual
                        "-" -> numeroAnterior - numeroActual
                        "*" -> numeroAnterior * numeroActual
                        "/" -> {
                            if (numeroActual != 0.0) numeroAnterior / numeroActual
                            else {
                                Toast.makeText(
                                    this,
                                    "Por favor, introduzca un valor válido",
                                    Toast.LENGTH_SHORT
                                ).show()
                                return@setOnClickListener
                            }
                        }

                        else -> numeroActual
                    }

                    resultado = if (valor % 1 == 0.0)
                        valor.toInt().toString()
                    else valor.toString()
                    binding.textViewContador?.setText(resultado)
                    numeroNuevo = true
                }
            }
        }
    }

