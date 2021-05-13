import java.lang.NumberFormatException

fun main() {

    println(ifExpression(18))
    println(whenExpression(17))
    println(tryExpression("18a"))
}

fun ifExpression(age: Int): String {
    //java style
    var canVote: String =""
//    if (age >=18){
//        canVote= "You can vote now"
//    }else {
//        canVote= "Not yet"
//    }
    return canVote
}

fun whenExpression(age: Int): String {
    return when (age) {
        in 18..101 -> "You can vote now"
        else -> "Not yet"
    }
}

fun tryExpression(age: String): String {
    return try {
        ifExpression(age.toInt())
    } catch (e: NumberFormatException) {
        println("Unexpected error: ${e.message}")
        ""
    }
}
