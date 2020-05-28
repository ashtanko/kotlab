package dev.shtanko.algorithms.sorts

fun Array<Int>.isSorted(): Boolean {
    return this.asSequence().zipWithNext { a, b -> a <= b }.all { it }
}