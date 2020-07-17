package dev.shtanko.concurrency.coroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val REPEAT_COUNT = 1000
private const val REPEAT_DELAY = 500L
private const val DELAY = 1300L

fun main() = runBlocking {
    GlobalScope.launch {
        repeat(REPEAT_COUNT) { i ->
            println("I'm sleeping $i ...")
            delay(REPEAT_DELAY)
        }
    }
    delay(DELAY) // just quit after delay
}
