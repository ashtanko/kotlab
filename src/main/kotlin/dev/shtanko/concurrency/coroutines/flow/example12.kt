package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

private const val MAX = 5

fun getData12(limit: Int) = (1..limit).asFlow()
    .filter {
        println("Filter $it")
        it % 2 == 0
    }
    .map {
        println("Map $it")
        "string $it"
    }

fun main() = runBlocking {
    getData12(MAX).collect {
        println("Collect $it")
    }
}
