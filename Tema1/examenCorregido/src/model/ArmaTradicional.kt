package model

class ArmaTradicional(
    id: Int,
    nivelPotencia: Int,
    nivelDanio: Int,
    nombre: String,
    var peso: Int


):Arma(id, nivelPotencia , nivelDanio, nombre) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("peso = ${peso}")
    }

}