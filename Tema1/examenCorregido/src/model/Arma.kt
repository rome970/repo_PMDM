package model

abstract open class Arma(

    var id: Int,
    var nivelPotencia: Int,
    var nivelDanio: Int,
    var nombre: String

) {

    open fun mostrarDatos(){
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("nivelPotencia = ${nivelPotencia}")
        println("nivelDaño = ${nivelDanio}")

    }

}