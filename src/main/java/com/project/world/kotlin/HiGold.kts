package com.project.world.kotlin

data class HiGold(val a: String, val b: String) {

}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor$i")
    }
}

Constructors(1)

fun hello(x: String) {
    println(x)
}


fun String.abc() {
    println("this like ruby method.")
}

"".abc()

println(arrayOf(1, 2, 3).javaClass)

val abc: Array<Number> = arrayOf(1, 2, 3)

println(mapOf(Pair("1", "2"))["1"])

println(mapOf(Pair(1, 2)).plus(mapOf(Pair(2, 3))))

println((2..33).last() == (2..33).last)
