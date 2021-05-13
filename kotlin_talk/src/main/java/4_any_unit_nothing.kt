import java.lang.IllegalArgumentException

fun main() {
    //any
    println(getAny(1).javaClass)
    println(getAny(5).javaClass)
    println(getAny(10).javaClass)

    //unit
    println(getUnit().javaClass)

    //Nothing
//    TODO("Implement me")
    doNothing()
    println("Can you reach here ?")
}

//Any
fun getAny(x: Int): Any {
    return when (x) {
        1 -> "String"
        2 -> 20 //Int
        3 -> 10f
        4 -> 20.0
        5 -> Pair("name|>", "Surname")
        else -> StringBuilder()
    }
}

//unit
fun getUnit():Unit {
    println("Do  something without return ")
}

//Nothing
fun doNothing():Nothing {
    throw IllegalArgumentException("Something went wrong")
}
