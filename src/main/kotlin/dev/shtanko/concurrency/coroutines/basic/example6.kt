package dev.shtanko.concurrency.coroutines.basic

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val START_COROUTINE_DELAY = 100L
private const val SECOND_COROUTINE_DELAY = 200L
private const val LAST_COROUTINE_DELAY = 500L

fun main() = runBlocking { // this: CoroutineScope
    launch {
        delay(SECOND_COROUTINE_DELAY)
        println("Task from runBlocking")
    }

    coroutineScope { // Creates a coroutine scope
        launch {
            delay(LAST_COROUTINE_DELAY)
            println("Task from nested launch")
        }

        delay(START_COROUTINE_DELAY)
        println("Task from coroutine scope") // This line will be printed before the nested launch
    }

    println("Coroutine scope is over") // This line is not printed until the nested launch completes
}
