import org.mariusz.Person
import java.lang.NumberFormatException

//scope functions
//let, run, with, apply, also

fun main() {

    //return context object at the end
    val tony = ScopePerson("Tony", "Stark", 0, 0).apply {
        this.age = 47
        this.weight = 85
    }

    tony.let {
        println(it)
        println(it.javaClass)
    }
}

