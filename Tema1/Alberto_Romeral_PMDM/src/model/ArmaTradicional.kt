package model

class ArmaTradicional(
    id :Int,
    nombre: String,
    nivelDaño : Int,
    nivelPotencia: Int,
    var peso: Int,


): Arma(id,nombre, nivelDaño,nivelPotencia) {

     var Mjölnir = ArmaTradicional(1,"Mjölnir",10,95,peso)


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("peso = ${peso}")
    }
}