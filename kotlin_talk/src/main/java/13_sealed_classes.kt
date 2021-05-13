

sealed class Vehicle {
    class Bus(val wheelNumber: Int) : Vehicle()
    class Airplane(val seats: Int) : Vehicle()
}
sealed interface ComputerPart
