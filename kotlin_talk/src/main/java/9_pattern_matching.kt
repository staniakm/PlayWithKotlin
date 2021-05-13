fun main() {
    match("Hello")
    match(1)
    match(15)
    match(1f)

    val name: Any = "John"
    if (name is String)
        println(name.toUpperCase())

}

fun match(input: Any): Unit {
    when (input) {
        is String -> println("It is a String and its length is ${input.toUpperCase()}")
        1, 2, 3 -> println("I'm the $input")
        in 10..18 -> println("To young to vote boy")
        else -> println("Opss, you did it again, ${input.javaClass}")
    }
}

data class GoodPerson(val name: String, val age: Int) {
    fun isOldEnough(): Boolean = age >= 18
    fun isTony(): Boolean = "Tony".equals(name, true)
}

fun match(input: GoodPerson) {
    when {
        input.isOldEnough() -> println("I can vote")
        input.isTony() -> println("I'm Iron man")
    }
}

