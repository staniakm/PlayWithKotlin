import org.mariusz.Person
import java.lang.NumberFormatException

//scope functions
//let, run, with, apply, also

fun main() {


    val tony = ScopePerson("Tony", "Stark", 0, 0).also { p ->
        p.age = 47
        p.weight = 85
    }

    tony.let {
        println(it)
        println(it.javaClass)
    }
}

