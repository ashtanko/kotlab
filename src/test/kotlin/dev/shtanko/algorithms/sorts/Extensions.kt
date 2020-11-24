package dev.shtanko.algorithms.sorts

fun IntArray.isSorted(): Boolean {
    return this.asSequence().zipWithNext { a, b -> a <= b }.all { it }
}

@Suppress("ArrayPrimitive")
fun Array<Int>.isSorted(): Boolean {
    return this.asSequence().zipWithNext { a, b -> a <= b }.all { it }
}
