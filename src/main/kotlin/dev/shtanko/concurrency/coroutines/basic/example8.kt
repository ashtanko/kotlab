package dev.shtanko.concurrency.coroutines.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val REPEAT_COUNT = 100_000
private const val DELAY = 1000L

fun main() = runBlocking {
    repeat(REPEAT_COUNT) { // launch a lot of coroutines
        launch {
            delay(DELAY)
            println(". $this ${Thread.currentThread()}")
        }
    }
}
