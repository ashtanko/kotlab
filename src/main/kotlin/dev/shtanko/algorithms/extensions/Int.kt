package dev.shtanko.algorithms.extensions

import kotlin.random.Random

val Int.isEven: Boolean
    get() = this % 2 == 0

fun Int.generateRandomArray(): IntArray {
    val array = IntArray(this)
    for (i in 0 until this) {
        array[i] = Random.nextInt(this)
    }
    return array
}
