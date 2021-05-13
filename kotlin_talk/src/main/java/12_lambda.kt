import java.lang.IllegalArgumentException

val sumNumbers: (Int, Int) -> Int = { a, b -> a + b }
val multiplyNumbers = { a: Int, b: Int -> a * b }
val subtractNumbers = { a: Int, b: Int -> a - b }
val divideNumbers: (Int, Int) -> Float =
    { a: Int, b: Int -> if (b == 0) throw IllegalArgumentException("Don't devide by zero") else a.toFloat() / b }
val getLongerString = { n1: String, n2: String -> if (n1.length > n2.length) n1 else n2 }


fun main() {
    calculate(1, 2, subtractNumbers).print()
    calculate(1, 2, sumNumbers).print()
    calculate(1, 2, multiplyNumbers).print()
    calculate(1, 2, divideNumbers).print()

    getLongerName("Jan", "Kamil", getLongerString).print()
    //with lambda inside function
    getLongerName("Joe", "Doe") { s: String, s2: String -> "$s $s2" }.print()
    //with anonymus function
    getLongerName("Joe", "Doe", fun(a: String, b: String) = "${a.toUpperCase()} ${b.toUpperCase()}").print()

    returnLambda("Sum").invoke(3, 4).print()
}

fun getLongerName(s: String, s1: String, function: (String, String) -> String): String {
    return function(s, s1)
}

fun calculate(a: Int, b: Int, func: (Int, Int) -> Int) = func(a, b)

fun calculate(a: Int, b: Int, func: (Int, Int) -> Float) = func(a, b)

fun returnLambda(prefix: String): (Int, Int) -> String {
    return { a: Int, b: Int -> "$prefix = ${a + b}" }
}


private fun Number.print() {
    println("result= $this")
}

fun String.print() {
    println(this)
}
