import java.math.BigDecimal


fun main() {

    println(11.javaClass)
    println(11f.javaClass)
    println("11f".javaClass)
    println(11.BD.javaClass)

}





private val Int.BD: BigDecimal
    get() = BigDecimal(this)
