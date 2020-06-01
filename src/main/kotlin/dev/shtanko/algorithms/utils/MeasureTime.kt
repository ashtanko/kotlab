package dev.shtanko.algorithms.utils

import dev.shtanko.algorithms.sorts.AbstractSortStrategy

fun measureTime(strategy: AbstractSortStrategy, array: IntArray, task: () -> Unit) {
    val startTime = System.currentTimeMillis()
    task()
    val elapsed = System.currentTimeMillis() - startTime
    println(
        String.format(
            "Arrays of length %d Strategy %s Consumed time: %d ms",
            array.size,
            strategy::class.java.simpleName,
            elapsed
        )
    )
}
