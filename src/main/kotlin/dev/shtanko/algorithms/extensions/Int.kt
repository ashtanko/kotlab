package dev.shtanko.algorithms.extensions

import kotlin.random.Random

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = IntPredicate { it % 2 == 0 }

val Int.isEven: Boolean
    get() = this % 2 == 0

fun Int.generateRandomArray(): IntArray {
    val array = IntArray(this)
    for (i in 0 until this) {
        array[i] = Random.nextInt(this)
    }
    return array
}

fun Int.lessThanZero(): Boolean {
    return this < 0
}
