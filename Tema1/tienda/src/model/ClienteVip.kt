package model;

class ClienteVip (

    id: Int,
    nombre: String,
    var añosMembresia: Int,
    var tipoMembresia: Int


    )  : Cliente(id,nombre) {


    fun descuentoMembresia(producto: Producto){

        println("Indique el tipo de membresia que tiene (1,2 o 3)")
        var precioReabajado: Double
        var precioActual = producto.precio ?: 0.0
        if (tipoMembresia == 1){
            producto.precio = precioActual - (0.2* precioActual)
            println("EL producto reabajado se quedaria en : ${producto.precio}")
        } else if (tipoMembresia == 2){
            producto.precio = precioActual - (0.3 * precioActual)
            println("EL producto reabajado se quedaria en : ${producto.precio}")
        }else if (tipoMembresia == 3){
            producto.precio = precioActual - (0.5*precioActual)
            println("EL producto reabajado se quedaria en : ${producto.precio}")
        }
    }


    override fun toString(): String {
        return super.toString()
        println("añosMembresia = ${añosMembresia}")
        println("tipoMembresia = ${tipoMembresia}")
    }
}
