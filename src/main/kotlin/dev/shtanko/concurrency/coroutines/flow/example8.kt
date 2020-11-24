package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

private const val DELAY = 1000L

suspend fun performRequestExample8(request: Int): String {
    delay(DELAY) // imitate long-running asynchronous work
    return "response $request"
}

suspend fun getExample8Data() = (1..3).asFlow() // a flow of requests
    .map { request -> performRequestExample8(request) }

suspend fun performExample8() = getExample8Data()
    .collect { response -> println(response) }

fun main() = runBlocking {
    performExample8()
}
