package dev.shtanko.algorithms.own

import kotlin.random.Random

private val whites: MutableList<Int> = mutableListOf()
private val blacks: MutableList<Int> = mutableListOf()

fun main() {
    repeat(2) {
        val r = Random.nextInt(2)
        if (r == 0) {
            whites.add(r)
        }
    }

    repeat(3) {
        val r = Random.nextInt(2)
        if (r == 1) {
            blacks.add(r)
        }
    }

    println(whites.size)
    println(blacks.size)
    println(whites.size.toFloat() / blacks.size.toFloat())
}
