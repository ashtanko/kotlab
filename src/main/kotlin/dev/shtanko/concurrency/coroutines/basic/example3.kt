package dev.shtanko.concurrency.coroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val PRE_EXECUTING_DELAY = 1000L
private const val POST_EXECUTING_DELAY = 2000L

fun main() = runBlocking<Unit> { // start basic.main coroutine
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(PRE_EXECUTING_DELAY)
        println("World!")
    }
    println("Hello,") // basic.main coroutine continues here immediately
    delay(POST_EXECUTING_DELAY) // delaying for 2 seconds to keep JVM alive
}
