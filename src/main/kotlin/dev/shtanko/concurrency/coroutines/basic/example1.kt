package dev.shtanko.concurrency.coroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val PRE_EXECUTING_DELAY = 1000L
private const val POST_EXECUTING_DELAY = 2000L

fun main() {
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(PRE_EXECUTING_DELAY) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello,") // basic.main thread continues while coroutine is delayed
    Thread.sleep(POST_EXECUTING_DELAY) // block basic.main thread for 2 seconds to keep JVM alive
}
