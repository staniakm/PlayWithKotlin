import org.mariusz.Person
import java.lang.NumberFormatException

//scope functions
//let, run, with, apply, also

fun main() {

    val tony = with(ScopePerson("Tony", "Stark", 0, 0)) {
        this.age = 47
        this.weight = 85
        this
    }

    tony.let {
        println(it)
        println(it.javaClass)
    }
}

