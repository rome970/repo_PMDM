package model

class Superheroe(
    var id: Int,
    var nombre: String,
    var nivel: Int)

{

    fun mostrarDatos(){
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("nivel = ${nivel}")
    }
}