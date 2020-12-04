package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.System.currentTimeMillis

object Example22 {
    private const val DELAY = 300L
    private const val PROCESSING_DELAY = 400L

    internal suspend fun getNums() = (1..3).asFlow().onEach { delay(DELAY) } // numbers 1..3 every 300 ms

    internal suspend fun getStrings() =
        flowOf("one", "two", "three").onEach { delay(PROCESSING_DELAY) } // strings every 400 ms

    internal suspend fun perform() {
        val nums = getNums()
        val strs = getStrings()
        val startTime = currentTimeMillis() // remember the start time
        nums.combine(strs) { a, b -> "$a -> $b" } // compose a single string with "combine"
            .collect { value -> // collect and print
                println("$value at ${currentTimeMillis() - startTime} ms from start")
            }
    }

    @JvmStatic
    fun main(args: Array<String>) = runBlocking {

    }
}
