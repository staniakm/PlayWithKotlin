//https://lambda.show/blog/arrow-io-monad
import arrow.fx.IO
import model.Address
import model.Customer
import model.Order
import arrow.core.Either
import arrow.fx.extensions.fx
import java.io.File
import java.lang.IllegalArgumentException

val orders: List<Order> = listOf<Order>(Order(1, 2), Order(2, 2))
val customers = listOf(Customer(1, 2), Customer(2, 2))
val addresses = listOf(Address(1), Address(2))


suspend fun main() {
    getAddressFromOrder(1).attempt()
        .map {
            when (it) {
                is Either.Left -> addressNotFound()
                is Either.Right -> processAddress(it.b)
            }
        }.suspended()


    eitherMonad { File("gradle.properties").readLines() }
        .let { result ->
            when (result) {
                is Result.Failure -> println("Failed to read data")
                is Result.Success<*> -> println(result.v)
            }
        }

}


fun getOrder(id: Int): IO<Order> = IO {
    orders.find { it.id == id }!!
}

fun getCustomer(id: Int): IO<Customer> = IO {
    customers.find { it.id == id }!!
}

fun getAddress(id: Int): IO<Address> = IO {
    addresses.find { it.id == id }!!
}

fun getAddressFromOrder(orderId: Int) = IO.fx {
    val order = !getOrder(orderId)
    val cust = !getCustomer(order.customerId)
    !getAddress(cust.addressId)
}


sealed interface Result {
    data class Success<T>(val v: T) : Result
    data class Failure(val message: String) : Result
}

fun <T> eitherMonad(fu: () -> T): Result {
    return try {
        Result.Success(fu.invoke())
    } catch (e: Throwable) {
        Result.Failure(e.message ?: "")
    }
}

fun processAddress(address: Address) {
    println("Processing address... $address")
}

fun addressNotFound() {
    println("Address not found")
}
