package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

private fun array(): Flow<Int> = flowOf(1, 1, 2, 2)

fun main() = runBlocking<Unit> {

    array()
        .transform { request ->
            emit("Making request $request")
        }
        .collect { value -> println(value) }
}
