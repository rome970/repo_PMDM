import model.Categoria
import model.Cliente
import model.ClienteVip
import model.Producto
import model.Tienda


fun main() {


/*

    println((1..14).random())
    var gorra = Producto()
    var pantalones = Producto(2, 10.0, categoria = Categoria.Ropa)
    var zapatillas = Producto(3, 30.0, "zapatillas", categoria = Categoria.Ropa)
    var cartera = Producto(4, 5.0, descripcion = "esta cartera es para guardar la pasta")
    var camiseta = Producto(1, 14.99, "Hola", "Si", categoria = Categoria.Ropa)

    // camiseta.mostrarDatos()

    val listaProductos: Array<Producto?> = arrayOf(gorra, pantalones, zapatillas, cartera, camiseta)
    val listaProductosTamano: Array<Producto?> = arrayOfNulls(5)
    // listaProductos[0] = null
    // listaProductos.forEach { it?.mostrarDatos() ?: println("Hueco vacío") }
    /* for (i in 0..listaProductos.size-1){
        if (listaProductos[i]?.id == 1){
            listaProductos[i] = null
        }
    } */

    /*
    var tienda = Tienda()
    tienda.agregarProducto(camiseta)
    tienda.agregarProducto(cartera)
    tienda.agregarProducto(zapatillas)
    tienda.mostrarProductos()
    */
    var cliente: Cliente = Cliente(1, "Jacobo")
    cliente.agregarProducto(Producto(id = 1))
    cliente.agregarProducto(Producto(id = 2))

    var vip : ClienteVip = ClienteVip(1,"albert",2,3)

    vip.descuentoMembresia(zapatillas)

*/


Menu()





}

fun Menu() {

    var producto: Producto
    var nuevoCLiente : Cliente = Cliente(1,"alberto")
    var tienda : Tienda = Tienda()
    while (true) {

        println("\n--- MENÚ PRINCIPAL ---")
        println("1. Agregar nuevo producto")
        println("2. Mostrar Productos ")
        println("3. Busqueda producto")
        println("4. Salir")


        print("Seleccione una opción: ")


        val opcion = readLine()?.toIntOrNull()



        when (opcion) {
            1 -> {
                println("Introduzca un id del prodcuto: ")
                var id = readln().toInt()
                println("Introduzca un precio del prodcuto: ")
                var precio = readln().toDouble()
                println("Introduzca un nombre del prodcuto: ")
                var nombre = readln().toString()
                println("Introduzca un descripcion del prodcuto: ")
                var descripcion = readln().toString()
                println("Introduzca una categoria del prodcuto: ")
                var categoriaIntroducida = readln().uppercase()
                var categoria = when(categoriaIntroducida){
                    "mueble" -> Categoria.Mueble
                    "tecnologia" -> Categoria.Tecnologia
                    "ropa" -> Categoria.Ropa
                    else ->  {
                        Categoria.Generica
                    }
                }

                 producto = Producto(id,precio,nombre,descripcion,categoria)
                nuevoCLiente.agregarProducto(producto)


            }
            2 -> {
                nuevoCLiente.obtenerProductos()


            }
            3 -> {
                println("Introduce el id del producto a buscar:")
                val id = readln().toInt()
                nuevoCLiente.informacionProducto(id)


            }
            4-> {
                break
            }

            else -> {

                println("Opción no válida. Por favor, introduzca un número del 1 al 3.")
            }
        }
    }
}
