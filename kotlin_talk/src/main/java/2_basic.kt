import java.lang.IllegalArgumentException

//kotlin optional syntax
fun main() {
    //semicolon
    val name = "Tony";
    var age = 40;

    //variable type
    val surname: String = "Stark"

    //not needed parameters
    val hero = Pair("Bruce", "Baner")
    val (hulkName, _) = hero
    println(hulkName)
}
