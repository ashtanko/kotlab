package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private const val DELAY = 1000L

suspend fun example3Foo(): List<Int> {
    delay(DELAY) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

fun main() = runBlocking {
    example3Foo().forEach { value -> println(value) }
}
