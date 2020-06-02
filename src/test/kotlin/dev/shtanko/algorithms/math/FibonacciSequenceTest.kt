package dev.shtanko.algorithms.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FibonacciSequenceTest {

    @Test
    fun `simple test`() {
        assertEquals(0, 0.toFibonacciSequence())
        assertEquals(1, 1.toFibonacciSequence())
        assertEquals(1, 2.toFibonacciSequence())
        assertEquals(2, 3.toFibonacciSequence())
        assertEquals(3, 4.toFibonacciSequence())
        assertEquals(5, 5.toFibonacciSequence())
        assertEquals(8, 6.toFibonacciSequence())
        assertEquals(13, 7.toFibonacciSequence())
        assertEquals(21, 8.toFibonacciSequence())
        assertEquals(34, 9.toFibonacciSequence())
        assertEquals(55, 10.toFibonacciSequence())
    }
}