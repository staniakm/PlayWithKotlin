import org.mariusz.Person
import java.lang.NumberFormatException

//scope functions
//let, run, with, apply, also

fun main() {

    //let
    val tony = ScopePerson("Tony", "Stark", 45, 80)
        .let {
            println(it)
            it.age = 46
            it
        }

    tony.let {
        println(it)
        println(it.javaClass)
    }
}

data class ScopePerson(val name: String, val surname: String, var age: Int, var weight: Int)
