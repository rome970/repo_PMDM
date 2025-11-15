import model.Vehiculo
import model.Moto
import model.Coche
import model.Coleccionable
import kotlin.reflect.typeOf

fun main() {
    var suzuki = Moto(
        "1234A","suzuki","CBR500",0,120,30000.0,false,"L")
    suzuki.mostrarDatos()


    var ford = Coche(
        "1234B","ford","focus",0,120,30000.0,5,650)
    ford.mostrarDatos()


    val listaVehiculo: ArrayList<Vehiculo> = arrayListOf()
    listaVehiculo.add(ford)
    listaVehiculo.add(suzuki)

    suzuki.realizarCaballito()
    ford.almacenarMaletero(500)

    listaVehiculo.forEach {
        if (it is Coleccionable){
            it.incrementarValor()
        }
        it.mostrarDatos()

    }


}