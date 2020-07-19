package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

private fun foo(): Flow<Int> = flow {
    emit(1)
    throw IllegalArgumentException("Just for test")
}

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit> {
    foo()
        .onCompletion { cause -> if (cause != null) println("Flow completed exceptionally") }
        .catch { println("Caught exception") }
        .collect { value -> println(value) }
}
