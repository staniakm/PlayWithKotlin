


fun main() {
    val name = "Tony"
    val surname = "Stark"
    val heroName = "Iron Man"
    stringTemplate(name, surname, heroName)

    stringMultiline(name, surname, heroName)
}

fun stringMultiline(name: String, surname: String, heroName: String) {
    val json = """
       *{
       *     "name": "$name",
       *     "surname":"$surname",
       *     "heroName":"$heroName"
       * }
    """.trimMargin("*")
    println(json)
}

fun stringTemplate(name: String, surname: String, heroName: String) {
    println("$name $surname, I'm ${heroName.toUpperCase()}")
}
