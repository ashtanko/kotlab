package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.runBlocking

private const val MAX = 100_000

fun main() = runBlocking<Unit> {
    val evenNumbers = (1..MAX).asFlow()
        .filter { it % 2 == 0 }

    evenNumbers.collect { value -> println(value) }
}
