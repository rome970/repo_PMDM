package model

class Producto(
    var id: Int? = null,
    var precio: Double? = null,
    var nombre: String? = null,
    var descripcion: String? = null,
    var categoria: Categoria = Categoria.Generica
) {
    fun mostrarDatos(){
        println("ID: ${id ?: "Sin definir"}")
        println("Precio: ${precio ?: "Sin definir"}")
        println("Nombre: ${nombre ?: "Sin definir"}")
        println("Descripcion: ${descripcion ?: "Sin definir"}")
        println("Categoria: $categoria")
    }

}