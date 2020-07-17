package dev.shtanko.concurrency.coroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val PRE_EXECUTING_DELAY = 1000L
private const val POST_EXECUTING_DELAY = 2000L

fun main() {
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(PRE_EXECUTING_DELAY)
        println("World!")
    }
    println("Hello,") // basic.main thread continues here immediately
    runBlocking { // but this expression blocks the basic.main thread
        delay(POST_EXECUTING_DELAY) // ... while we delay for 2 seconds to keep JVM alive
    }
}
