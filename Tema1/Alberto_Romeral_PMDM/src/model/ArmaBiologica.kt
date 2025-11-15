package model

class ArmaBiologica(
    id :Int,
    nombre: String,
    nivelDaño : Int,
    nivelPotencia: Int,
    var descripcion: String


    ): Arma(id,nombre, nivelDaño,nivelPotencia) {





    override fun mostrarDatos() {
        super.mostrarDatos()
        println("descripcion = ${descripcion}")
    }
}