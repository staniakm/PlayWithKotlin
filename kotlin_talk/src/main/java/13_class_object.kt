fun main() {
    val config1 = Config
    println(config1)
    config1.password = "new Password"
    println(config1)
    val config2 = Config
    println(config2)
    config2.password = "oldpass"
    println(config1)
    println(config1.doSomething("John"))

    //
    val c = Computer("IBM")
    Computer.someParam = "IBM"
    Computer.desc().print()
}


object Config {
    val url: String = "url"
    var password: String = "pass"
    override fun toString(): String {
        return """
            url: $url,
            pass: $password
        """.trimIndent()
    }

    fun doSomething(name: String): String {
        return "$name set pass = $password"
    }
}


class Computer(val manufacturer: String) {
    var price: Int = 0

    companion object {
        var someParam: String = "Computer"
        fun desc(): String {
            return "Basic $someParam"
        }
    }
}
