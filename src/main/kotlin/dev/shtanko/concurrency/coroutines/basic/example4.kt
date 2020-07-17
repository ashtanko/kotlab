package dev.shtanko.concurrency.coroutines.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val DELAY = 1000L

fun main() = runBlocking {
    val job = GlobalScope.launch { // launch a new coroutine and keep a reference to its Job
        delay(DELAY)
        println("World!")
    }
    println("Hello,")
    job.join() // wait until child coroutine completes
}
