fun calcularPrecios(precio:Int?){
    //Mediante operador elvis, damos valor de 100 si es nulo
    val precioBase = precio?: 100

    val descuento = if (precioBase > 50){
        precioBase * 0.10
    }else precioBase * 0.05

    val precioFinal = precioBase - descuento


    println("El precio base es: $precioBase")
    println("El descuento aplicado es: $descuento")
    println("El precio final es: $precioFinal")
}

fun main() {
    // Llamada con precio null
    calcularPrecios(null)
    println()

    // Llamada con precio 30
    calcularPrecios(30)
}