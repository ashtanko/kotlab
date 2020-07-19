package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

private const val DELAY = 100L

// Imitate a flow of events
private fun events(): Flow<Int> = (1..3).asFlow().onEach { delay(DELAY) }

fun main() = runBlocking<Unit> {
    events()
        .onEach { event -> println("Event: $event in ${Thread.currentThread().name}") }
        .launchIn(this) // <--- Launching the flow in a separate coroutine
    println("Done")
}
