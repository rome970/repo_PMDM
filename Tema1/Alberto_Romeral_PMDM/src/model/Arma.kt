package model

open class Arma (
    var id: Int,
    var nombre: String,
    var nivelPotencia: Int,
    var nivelDaño: Int

    ){





    open fun mostrarDatos(){
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("nivelPotencia = ${nivelPotencia}")
        println("nivelDaño = ${nivelDaño}")


    }
}