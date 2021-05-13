import java.time.LocalDate

fun main() {
    val car1 = KotlinCar("make", "model", 2020, 1200)
    val car2 = KotlinCar("make", "model", 2020, 1200)

    //equals && hashcode
    println("class equality:  ${car1 == car2}")
    println("class reference:  ${car1 === car2}")
    println("class reference:  ${car1 === car1}")


    //data class copy
    val car3 = car1.copy(make = "Ford", model = "Focus")
    //toString
    println(car3)

    //componentN
    val (make, model, _, engineCapacity) = car3
    val carMake = car3.component1()


    println("$make - $model == $engineCapacity")
    println(car3.howOldIsIt())
    println(car3.old)

}

data class KotlinCar(
    var make: String?,
    var model: String?,
    var manufacturingYear: Int?,
    var engineCapacity: Int?
) {

    val old
        get() = LocalDate.now().year - (manufacturingYear ?: LocalDate.now().year)

    fun howOldIsIt(): Int {
        return LocalDate.now().year - (manufacturingYear ?: LocalDate.now().year)
    }
}


