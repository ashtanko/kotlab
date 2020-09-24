package dev.shtanko.concurrency.coroutines.channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import kotlin.system.measureTimeMillis

private const val REPEAT_TIMES = 100_000_000

suspend fun sum2(s: List<Int>, c: SendChannel<Int>) {
    // simulate long-running CPU-consuming computation
    var sum = 0
    val time = measureTimeMillis {
        repeat(REPEAT_TIMES) {
            for (v in s) {
                sum += v
            }
        }
        c.send(sum)
    }
    println("Sum took $time ms")
}

fun main() = mainBlocking {
    val s = listOf(1, 2)
    val c = Channel<Int>()
    go { sum2(s.subList(s.size / 2, s.size), c) }
    go { sum2(s.subList(0, s.size / 2), c) }
    val time = measureTimeMillis {
        val x = c.receive()
        val y = c.receive()
        println("$x $y ${x + y}")
    }
    println("Main code took $time ms")
}
