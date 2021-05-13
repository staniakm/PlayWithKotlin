import org.mariusz.Person

fun main() {
    var name: String? = giveMeName(2)

    if (name != null)
        println(name.toUpperCase())

    println(name!!.toLowerCase().capitalize())
}

fun giveMeName(v: Int): String? {
    return if (v == 1) {
        "Capitan America"
    } else {
        null
    }
}

fun getCity(p: Person): String {
    return p.company?.address?.city?.toUpperCase() ?: ""
}
