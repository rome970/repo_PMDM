package model
class Humano(

    id: Int =  readln().toInt(),
    nombre: String = readln().toString(),
    nivel: Int = readln().toInt(),
    var resistencia: Int = readln().toInt(),

): Superheroe(id,nombre,nivel) {
    override fun crearSuperheroe() {
        super.crearSuperheroe()
        println("Introduzca la resistencia del humano: ")
        resistencia = readln().toInt()
        println("Introduzca el arma del humano")

    }

    override fun mostrarDatos() {
        println("DATOS DEL HUMANO")
        super.mostrarDatos()
        println("resistencia = ${resistencia}")
    }
}