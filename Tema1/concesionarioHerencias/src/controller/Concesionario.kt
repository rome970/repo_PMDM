package controller

import model.Vehiculo

class Concesionario {
    lateinit var listaVehiculos: ArrayList<Vehiculo>
    init {
        listaVehiculos = arrayListOf()
    }

    fun agregarVehiculo(vehiculo: Vehiculo){
        listaVehiculos.add(vehiculo)
    }

}