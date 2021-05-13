fun main() {
//    doLoop(3)
//    whileDoLoop(3)
//    repeatLoop()
//    forLoop()
    forEachLoop()
    rangeLoop()

}

fun rangeLoop(){
    (1..4).forEach {
        println("$it - forEach with range")
    }

}


fun repeatLoop() {
    repeat(4) {
        println("repeat run no. $it")
    }
}

fun forEachLoop() {
    val names = listOf("Tony", "Thor", "Bruce", "Steve", "Wanda", "Victor")

    for (name in names) {
        println(name)
    }
}

fun forLoop() {
    for (i in 1..5) {
        println("for loop no. $i")
    }
}

fun whileDoLoop(i: Int) {
    var tmp = i
    while (tmp > 0) {
        println("while do : $tmp")
        tmp--
    }
}

fun doLoop(i: Int) {
    var tmp = i
    do {
        println("do while: $tmp")
        tmp--
    } while (tmp > 0)
}
