package model

class Tienda(var nombre: String? = null) {
    var caja: Double = 0.0
    var almacen: Array<Producto?>

    init {
        almacen = arrayOfNulls(5)
    }

    fun mostrarProductos() {
        var nulos: Int = 0
        almacen.forEach { it?.mostrarDatos() ?: nulos++ }
        if (nulos == almacen.size) println("Almacen vacío")
    }

    fun filtrarPorCategoria(categoria: Categoria) {
        val listaFiltrada = almacen.filter { it?.categoria == categoria } as ArrayList<Producto?>

    }

    fun agregarProducto(producto: Producto){
        val busqueda: Producto? = almacen.find {

            return@find it?.id == producto.id
        }
        for (i in almacen.indices){
            if (almacen[i] == null){
                almacen[i] = producto
                println("Producto agregado correctamente")
                return
            }
        }
        println("Producto")
    }

}
