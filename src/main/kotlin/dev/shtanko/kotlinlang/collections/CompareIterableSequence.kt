package dev.shtanko.kotlinlang.collections

import dev.shtanko.algorithms.extensions.isEven

fun main() {

    val smallList = (0..2)
    val smallSequence = smallList.asSequence()

    getFirstFromList(smallList)
    println()
    getFirstFromSequence(smallSequence)
}

fun getFirstFromList(list: IntRange) {
    list
        .map { println("map $it"); it * 2 }
        .filter { println("filter $it"); it.isEven }
        .take(1)
        .forEach { println("list $it") }
}

fun getFirstFromSequence(sequence: Sequence<Int>) {
    sequence
        .map { println("map $it"); it * 2 }
        .filter { println("filter $it"); it.isEven }
        .take(1)
        .forEach { println("sequence $it") }
}
