import java.lang.StringBuilder

fun main() {
    //extension function
    val wavedString = "wave me this string".wave()
    println(wavedString)

    //extension function with receiver
    val sb = StringBuilder()

    val newString = "A long time ago, in a galaxy far, far away...".continueStory(sb) {
        appendLine()
        append("It is a period of civil war.")
        appendLine()
        append(
            """ Rebel
                spaceships, striking from a hidden
                base, have won their first victory
                against the evil Galactic Empire. """.trimIndent()
        )
    }
    println(newString)

}

private fun String.continueStory(sb: StringBuilder, function: StringBuilder.() -> Unit): String {
    sb.append(this)
    sb.function()
    return sb.toString()
}

private fun String.wave(): String {
    return this.split("")
        .mapIndexed { i, ch -> if (i % 2 == 0) ch.toUpperCase() else ch.toLowerCase() }
        .joinToString("")
}
