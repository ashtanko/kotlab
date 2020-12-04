package dev.shtanko.concurrency.coroutines.flow

import java.lang.System.currentTimeMillis
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

private const val DELAY = 100L
private const val WAIT_DELAY = 500L

private fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(WAIT_DELAY) // wait 500 ms
    emit("$i: Second")
}

@OptIn(FlowPreview::class)
fun main() = runBlocking<Unit> {
    val startTime = currentTimeMillis() // remember the start time
    (1..3).asFlow().onEach { delay(DELAY) } // a number every 100 ms
        .flatMapConcat { requestFlow(it) }
        .collect { value -> // collect and print
            println("$value at ${currentTimeMillis() - startTime} ms from start")
        }
}
