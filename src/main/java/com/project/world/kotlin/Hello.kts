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

    val x = 6
    when (x) {
        in 1..20 -> println("x include 1..20")
        in 2..20 -> println("x include 2..20")
        else -> println("default else.")
    }

    when {
        x > 2 -> println("x big than 2")
        x > 3 -> println("x big than 3")
        else -> println("default else.")
    }

    for (id in 2..30) {
        print(id)
    }

    fun foo() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return // 非局部直接返回到 foo() 的调用者
            print(it)
        }
        println("this point is unreachable")
    }

    foo()
    println()

    fun foo1() {
        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
            print(it)
        }
        println(" done with explicit label")
    }

    foo1()

    fun foo2() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
            print(it)
        }
        println(" done with implicit label")
    }

    foo2()

    fun foo3() {
        listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
            if (value == 3) return  // 局部返回到匿名函数的调用者，即 forEach 循环
            print(value)
        })
        println(" done with anonymous function")
    }

    foo3()
}

main()