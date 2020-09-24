package dev.shtanko.concurrency.coroutines.channels

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Example3Test {

    @ExperimentalCoroutinesApi
    @Test
    fun `fibonacci channel test`() = runBlocking {
        val c = Channel<Int>(2)
        go { fibonacci(9, c) }
        val list = mutableListOf<Int>()
        for (i in c) {
            list.add(i)
        }
        assertEquals(listOf(0, 1, 1, 2, 3, 5, 8, 13, 21), list)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `fibonacci channel test 2`() = runBlocking {
        val list = mutableListOf<Int>()
        val c = Channel<Int>(2)
        val quit = Channel<Int>(2)
        go {
            for (i in 0..9)
                list.add(c.receive())
            quit.send(0)
        }
        fibonacci(c, quit)
        assertEquals(listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), list)
    }
}
