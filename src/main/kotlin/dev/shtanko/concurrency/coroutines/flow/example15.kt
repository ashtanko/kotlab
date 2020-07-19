package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

private const val DELAY = 100L

private fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

private fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(DELAY) // pretend we are computing it in CPU-consuming way
        log("Emitting $i")
        emit(i) // emit next value
    }
}.flowOn(Dispatchers.Default) // RIGHT way to change context for CPU-consuming code in flow builder

fun main() = runBlocking<Unit> {
    foo().collect { value ->
        log("Collected $value")
    }
}
