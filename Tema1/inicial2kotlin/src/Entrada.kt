fun main(args: Array<String>) {

    val DNI = "123123123A"
    var nombre: String = "Borja"
    var edad: Number = 41
    lateinit var correo: String // lateinit permite que la var/val sea inicializada más adelante. Excepto Int por que primitivamente Int = 0
    var direccion: String? = "Pozuelo" // ? permite que la var/val pueda ser null. (nullSafety)

    val conocimientos = arrayListOf("")

    println("Primer programa de repaso Kotlin")

    correo = "borja@retamar.es"

    println("Hola mi nombre es $nombre, tengo $edad " +
            "y mi correo es $correo")

    println("Mi nombre tiene ${nombre.length} letras ")

    println("Vivo en ${direccion?.length ?: "sin definir"}") // ?: (elvis) si el valor es null, hace lo siguiente a ?:

    println("A quien quieres saludar?")
    nombre= readln()

    println("Cuantas veces quieres hacerlo")
    var veces: Int = readln().toInt()
    saludar(nombre = nombre, veces = veces)

    saludar()
}

fun saludar(nombre: String? = null, veces: Int? = null) {
    // saludar a la persona con el nombre pasado
    // un número determinado de veces
    for(i in 0..veces - 1){
        println("Hola $nombre que tal estás.")
    }

}

