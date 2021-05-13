package javaToKotlin

import java.time.LocalDate

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


fun kotlinCalculations(name: String): String {
    println("calculating......")
    return name.toUpperCase()
}

