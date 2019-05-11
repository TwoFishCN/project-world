package com.project.world.kotlin

class Hello {

    fun showA(a: String) {
        println(a)
    }

    fun showB(b: String) {
        println("hello show B$b")
    }

    fun showMore(vararg args: Int) {
        val buffer = StringBuffer()
        for (arg in args) {
            buffer.append(arg)
        }

        println(buffer.toString())
    }
}

fun main() {

    val hello = Hello()

    println("Hell world.")
    hello.showA("niceA")
    hello.showB("niceB")

    hello.showMore(1, 2, 3, 4, 5, 6, 7)

    val hi = HiGold.HiGold("a-value", "b-value")

    println(hi.a + hi.b)

    println(hi.toString())

    println("i am main.")

//    Thread.sleep(3000)


    println("Sleep 3 send end.")
}

main()