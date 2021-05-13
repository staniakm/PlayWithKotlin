class ElectricCar(val make: String) : Vehicle()

class Mouse(val dpi: Int) : ComputerPart
class Keyboard(val color: String) : ComputerPart


fun process(vehicle: Vehicle) {
    when (vehicle) {
        is ElectricCar -> println("Make: ${vehicle.make}")
        is Vehicle.Airplane -> println("Number of seats ${vehicle.seats}")
    }
}

fun process(computerPart: ComputerPart) {
    when (computerPart) {
        is Keyboard -> TODO()
        is Mouse -> TODO()
    }
}
