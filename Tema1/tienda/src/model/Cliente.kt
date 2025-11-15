package model

open class Cliente(var id: Int, var nombre: String) {

    var factura: Double = 0.0
    lateinit var carrito: ArrayList<Producto>

    init {
        carrito = ArrayList()
    }

    fun agregarProducto (producto: Producto) {
        if (carrito.find { it.id == producto.id } != null) {
            println("El producto ya en el carrito")
            return
        }
        carrito.add(producto)
        factura += producto.precio ?: 0.0
        println("Agregado correctamente")
    }

    fun obtenerProductos() {
        if (carrito.isEmpty()) println("El carrito no tiene productos")
        carrito.forEach { it.mostrarDatos() }
    }

    fun informacionProducto(id : Int) {

        carrito.find{it.id == id}?.mostrarDatos()
            ?: println("No se ha encontrado producto con ese id.")
    }

    fun borrarCategoria(categoria:Categoria){
        val listaFiltrada = carrito.filter { it.categoria == categoria}
        when(listaFiltrada.size){
            0->{
                println("No se han encontrado carritos con esa cattegoria")
            }
            1->{
                carrito.remove(listaFiltrada.first())
                carrito.remove(listaFiltrada[0])
                carrito.remove(listaFiltrada.get(0))
            }
            else -> {
                println("Cuantos carritos quieres borrar")
                var nBorrados = readln().toInt()
                if (nBorrados==listaFiltrada.size){
                    carrito.removeAll(listaFiltrada)
                }else if(nBorrados<listaFiltrada.size){
                    for (i in 0..nBorrados-1){
                        carrito.remove(listaFiltrada[i])
                    }

                }
            }
        }
    }


}