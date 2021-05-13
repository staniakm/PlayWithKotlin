fun main() {
    val names = listOf("Tony", "Thor", "Bruce", "Steve", "Wanda", "Victor")

    names
//        .asSequence()
        .filter (::filterOutShorterThan4)
        .map(::mapToUppercase)
        .take(2)
        .reduce { acc, s -> "$acc - $s" }
        .also {
            println(it)
        }
}

fun filterOutShorterThan4(name: String): Boolean {
    println("filtering $name")
    return name.length > 4
}

fun mapToUppercase(name: String): String {
    println("mapping $name")
    return name.toUpperCase()
}
