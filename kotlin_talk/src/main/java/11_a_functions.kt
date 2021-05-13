

fun main() {
    val name: String = simpleFunction("Tony")
    val surname: String = anotherSimpleFunction("Stark")
}

fun anotherSimpleFunction(s: String) = s.toUpperCase()

fun simpleFunction(s: String): String {
    return s.toLowerCase()
}
