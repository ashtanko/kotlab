package dev.shtanko.algorithms.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NewtonMethodTest {

    @Test
    fun `calculate sqrt newton method test one`() {
        assertTrue(sqrt(-2.0).isNaN())
        assertTrue(sqrt(-2.0, 0.toDouble()).isNaN())
        assertEquals(2.toDouble(), sqrt(4.toDouble()), 1e-15)
        assertEquals(4.toDouble(), sqrt(16.toDouble()), 1e-12)
    }

    @Test
    fun `calculate sqrt newton method test two`() {
        assertTrue(sqrt(-2).isNaN())
        assertEquals(2.toDouble(), sqrt(4), 1e-15)
        assertEquals(4.toDouble(), sqrt(16), 1e-12)
    }
}