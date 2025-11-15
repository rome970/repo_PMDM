import model.ArmaTradicional
import model.Humano
import model.Mutante
import model.Superheroe

fun main() {

        // DON BORJA -> por consola va a leer primero los datos de cada objeto humano(int,string,int,int)
    // mutante(int, string, int) sino da error. Lo siento por la cutrez. Después ya la lleva al "menú" que he creado
         var humano1 = Humano()
         var mutante1 = Mutante()

    fun crearLosSuperheroes(){
        println("======Creacion humano=====")
        humano1.crearSuperheroe()
        println("======Creacion mutante=======")
        mutante1.crearSuperheroe()
    }
    fun listarSuperheroes() {
        println("======Datos humano=====")
        humano1.mostrarDatos()
        println("======Datos mutante=====")
        mutante1.mostrarDatos()
    }

    fun menu(){
        println("""
            =====MENU====
            OPCION 1 : CREAR SUPERHEROES
            OPCION 2 : LISTAR SUPERHEROES
            
        """.trimIndent())
        println("Introduzca una opcion: ")
        var opcion = readln().toInt()
        if (opcion == 1){
            crearLosSuperheroes()
        }
        if (opcion == 2) {
            listarSuperheroes()
        }

    }
    menu()






}