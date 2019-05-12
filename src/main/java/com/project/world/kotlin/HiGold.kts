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
