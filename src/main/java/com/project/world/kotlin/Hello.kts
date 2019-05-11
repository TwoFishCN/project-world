package com.project.world.kotlin

class Hello {

    fun showA(a: String) {
        println(a)
    }

    fun showB(b: String) {
        println("hello show B$b")
    }
}

println("hell world.")
Hello().showA("niceA")
Hello().showB("niceB")

val hi = HiGold.HiGold("a-value","b-value")

println(hi.toString())

fun main(){
    println("i am main.")
}