package model

class Electrico (
    matricula: String,
    marca: String,
    modelo: String,
    km: Int,
    cv: Int,
    precio: Double,
    nPuertas: Int,
    capacidadMaletero: Int,
    var puertoCarga: Boolean,
    var autonomiaElectrica: Int
): Coche(matricula,marca,modelo,km,cv,precio,nPuertas, capacidadMaletero){

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("puertoCarga = ${puertoCarga}")
        println("autonomiaElectrica = ${autonomiaElectrica}")
    }



}