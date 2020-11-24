package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val DELAY = 100L

fun example4Foo(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(DELAY) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

fun main() = runBlocking {
    // Launch a concurrent coroutine to check if the basic.main thread is blocked
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(DELAY)
        }
    }
    // Collect the flow
    example4Foo().collect { value -> println(value) }
}
