package dev.shtanko.concurrency.coroutines.channels

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class Example2ATest {

    @ExperimentalCoroutinesApi
    @Test
    fun `simple test`() = runBlocking {
        val s = listOf(7, 2, 8, -9, 4, 0)
        val c = Channel<Int>()
        go { sum(s.subList(s.size / 2, s.size), c) }
        go { sum(s.subList(0, s.size / 2), c) }
        val time = measureTimeMillis {
            val x = c.receive()
            val y = c.receive()
            println("$x $y ${x + y}")
            assertEquals(12, x + y)
        }
        println("Main code took $time ms")
    }
}
