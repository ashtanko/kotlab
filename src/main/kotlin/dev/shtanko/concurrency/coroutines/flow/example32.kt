package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

private fun foo(): Flow<Int> = (1..3).asFlow()

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit> {
    foo()
        .onCompletion { println("Done") }
        .collect { value -> println(value) }
}