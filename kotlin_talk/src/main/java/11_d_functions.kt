fun main() {
    //varargs
    val names = arrayOf("Tony", "Thor", "Bruce", "Steve", "Wanda", "Victor")
//    println(varargsFun("Tony", "Thor", "Bruce", "Steve", "Wanda", "Victor"))
    println(varargsFun(*names))
    println(varargsFun("Natasha", *names, "Nick"))

}

fun varargsFun(vararg names: String): String = names.joinToString(separator = " : ")
