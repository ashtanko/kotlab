package dev.shtanko.algorithms.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinomialTest {

    @Test
    fun `simple test`() {
        assertEquals(0, binomial(0, 1))
        assertEquals(1, binomial(1, 1))
        assertEquals(2, binomial(2, 1))
        assertEquals(3, binomial(3, 1))
        assertEquals(3, binomial(3, 2))
        assertEquals(4, binomial(4, 1))
        assertEquals(1, binomial(5, 0))
        assertEquals(5, binomial(5, 1))
        assertEquals(10, binomial(5, 2))
        assertEquals(10, binomial(5, 3))
        assertEquals(5, binomial(5, 4))
        assertEquals(1, binomial(5, 5))
        assertEquals(1, binomial(6, 0))
        assertEquals(6, binomial(6, 1))
        assertEquals(15, binomial(6, 2))
        assertEquals(20, binomial(6, 3))
        assertEquals(15, binomial(6, 4))
        assertEquals(6, binomial(6, 5))
    }
}
