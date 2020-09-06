package dev.shtanko.concurrency.coroutines.channels

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val PUBLISH_TIMES = 5
fun main() = runBlocking {

    val channel = Channel<Int>()
    GlobalScope.launch {
        for (i in 1..PUBLISH_TIMES) channel.send(i * i)
    }
    repeat(PUBLISH_TIMES) { println(channel.receive()) }
    println("Done!")
}
