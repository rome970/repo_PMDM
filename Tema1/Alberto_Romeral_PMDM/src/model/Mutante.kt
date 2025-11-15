package model

class Mutante(
    id : Int = readln().toInt(),
    nombre: String = readln().toString(),
    nivel: Int = readln().toInt(),
): Superheroe(id,nombre,nivel) {


    override fun crearSuperheroe() {
        super.crearSuperheroe()
    }

    override fun mostrarDatos() {
        println("DATOS DEL MUTANTE")
        super.mostrarDatos()
    }
}