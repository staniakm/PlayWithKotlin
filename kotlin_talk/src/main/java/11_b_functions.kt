fun main() {
    //functions with default parameters
    println(callMyName())
    println(callMyName("Tony"))
    println(callMyName(surname = "Stark", name = "Tony"))

}

fun callMyName(name: String = "John", surname: String = "Doe", fullName:String = "$name ${surname.toUpperCase()}"): String {
    return "$name - $surname - $fullName"
}


