package model

open class Superheroe(
    var id: Int = readln().toInt(),
    var nombre: String = readln().toString(),
    var nivel: Int = readln().toInt()

) {


    open fun crearSuperheroe(){
        println("Introduzca el id del superheroe: ")
        id = readln().toInt()
        println("Introduzca el nombre del superheroe: ")
        nombre = readln().toString()
        println("Introduzca el nivel del superheroe: ")
        nivel = readln().toInt()

    }


    open fun mostrarDatos(){

        println("id = ${id}")
        println("nombre = ${nombre}")
        println("nivel = ${nivel}")
    }

}