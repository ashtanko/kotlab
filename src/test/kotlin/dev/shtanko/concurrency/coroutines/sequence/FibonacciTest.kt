package dev.shtanko.concurrency.coroutines.sequence

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FibonacciTest {

    @ExperimentalCoroutinesApi
    @Test
    fun `simple test`() = runBlocking {
        val actual = fibonacci.take(10).joinToString()
        val expected = "1, 1, 2, 3, 5, 8, 13, 21, 34, 55"
        assertEquals(expected, actual)
    }
}
