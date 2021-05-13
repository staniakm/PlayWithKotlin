import kotlin.random.Random
import kotlin.reflect.KProperty

class ClassDelegate {

    var name: String by Delegate()

    val l: String by lazy {
        println("Calculating")
        "test"
    }
}


fun main() {
    val c = ClassDelegate()
    println(c.name)
    c.name = " name with spaces       "
    println("[${c.name}]")
    println(c.l)
    println(c.l)

    calculation()
}

private fun calculation() {
    val v by lazy { calculateSomething() }
    val b = Random.nextInt(1, 10) > 5
    println("b=$b")
    if (b || v == "Calculated") {
        println("inside if")
    }
}

fun calculateSomething(): String {
    println("calculateig some function")
    return "Calculated"
}


class Delegate {
    private var f: String = ""
    operator fun getValue(classDelegate: ClassDelegate, property: KProperty<*>): String {
        return f.capitalize()
    }

    operator fun setValue(classDelegate: ClassDelegate, property: KProperty<*>, s: String) {
        f = s.trim().toUpperCase()
    }
}
