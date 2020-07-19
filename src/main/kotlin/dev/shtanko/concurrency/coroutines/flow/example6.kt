package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

private const val DELAY = 100L
private const val TIMEOUT = 250L

private fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(DELAY)
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(TIMEOUT) { // Timeout after 250ms
        foo().collect { value -> println(value) }
    }
    println("Done")
}
