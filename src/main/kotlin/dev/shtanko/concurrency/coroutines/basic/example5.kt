package dev.shtanko.concurrency.coroutines.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val DELAY = 1000L

fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine in the scope of runBlocking
        delay(DELAY)
        println("World!")
    }
    println("Hello,")
}
