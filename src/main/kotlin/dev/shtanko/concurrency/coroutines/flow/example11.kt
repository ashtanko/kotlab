package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

private const val MAX = 5

suspend fun getData11(limit: Int) = (1..limit).asFlow()
    .map { it * it } // squares of numbers from 1 to 5
    .reduce { a, b -> a + b } // sum them (terminal operator)

fun main() = runBlocking {
    val sum = getData11(MAX)
    println(sum)
}
